package com.educode.minecraft.gui;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.networking.MessageSaveFile;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.xml.soap.Text;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Set;

import static org.lwjgl.input.Keyboard.*;


@SideOnly(Side.CLIENT)
public class GuiProgramEditor extends GuiScreen
{
    private static final ResourceLocation BOOK_GUI_TEXTURES = new ResourceLocation("textures/gui/book.png");

    private static String _text = "";
    private static String _formattedText = "";
    private static String _fileName;
    private static int _position = 0;
    private static int _lineNumber = 0;
    private static final char _cursorSymbol = '|';

    public GuiProgramEditor()
    {
        super();
    }

    public static void setFileName(String name)
    {
        _fileName = name;
    }

    private static Tuple<String[], String> testWords(String[] words, Set<String[]> keySet, String[] partialKeywords)
    {
        Tuple<Integer, String[]> keywords;
        String partial = "";
        for (String word : words)
        {

            if (partial.equals(""))
            {
                keywords = testWord(word,keySet,partialKeywords);
                switch(keywords.getFirst())
                {
                    case 0:
                        break;
                    case 1:
                        return new Tuple<>(keywords.getSecond(), word);
                    case 2:
                        partial = word;
                        break;
                }
            }
            else
            {
                keywords = testWord(new StringBuffer(partial + " " + word).toString(),keySet,partialKeywords);
                switch(keywords.getFirst())
                {
                    case 0:
                        break;
                    case 1:
                        //if (new StringBuffer(partial + " " + word).toString().equals("less than") ||
                        //    new StringBuffer(partial + " " + word).toString().equals("greater than"))
                        //{
                        //TODO: Special cases
                        //}
                        return new Tuple<>(keywords.getSecond(), word);
                    case 2:
                        partial = new StringBuffer(partial + " " + word).toString();
                        break;
                }
            }

        }
        return new Tuple<>(null, null);
    }
    private static Tuple<Integer, String[]> testWord(String word, Set<String[]> keySet, String[] partialKeywords)
    {
        for(String[] keywords : keySet)
        {
            for (String keyword : keywords)
            {
                if(word.equals(keyword))
                {
                    return new Tuple<>(1, keywords);
                }
                else
                {
                    for (String partialKeyword : partialKeywords)
                    {
                        if (word.equals(partialKeyword))
                        {
                            return new Tuple<>(2, null);
                        }
                    }
                }
            }
        }
        return new Tuple<>(0, null);
    }


    public static void setText(String text)
    {
        String[] partialKeywords = new String[] {"end", "repeat", "less", "greater"};
        String[] blueKeywords = new String[] {"program", "end program", "method", "end method", "if", "then", "else", "end if", "repeat while", new Regex("(return(s)?)").toString()};
        String[] yellowKeywords = new String[] {"not", "equals", "less than", "greater than", "or", "and"};


        HashMap<String[], TextFormatting> keyWordMap = new HashMap<String[], TextFormatting>();
        keyWordMap.put(blueKeywords, TextFormatting.BLUE);
        keyWordMap.put(yellowKeywords, TextFormatting.YELLOW);

        _text = text.replace("\r", "");
        StringBuffer newFormattedText = new StringBuffer(_text).insert(_position, _cursorSymbol);

        String[] _lines = newFormattedText.toString().split("(\n)");

        Set<String[]> keySet = keyWordMap.keySet();


        for(String line : _lines) {
            Tuple<String[], String> key = testWords(line.split("( )"), keySet, partialKeywords);

            if (key.getFirst() != null) {
                TextFormatting col = keyWordMap.get(key.getFirst());
                newFormattedText.append(col + key.getSecond() + " " + TextFormatting.WHITE);
            } else {
                newFormattedText.append(key.getSecond() + " ");
            }
        }



        // Perform syntax highlighting using regex
        //Blue keywords
        //newFormattedText = newFormattedText.replaceAll("(program | program |\nprogram | method |\nmethod )", TextFormatting.BLUE + "$1" + TextFormatting.WHITE);
        //newFormattedText = newFormattedText.replaceAll("( end program|\nend program| end if | end if\n|\nend if |\nend if\n| end method | end method\n|\nend method |\nend method\n| if|then|else|while|repeat|method|return(s)?)", TextFormatting.BLUE + "$1" + TextFormatting.WHITE);
        //newFormattedText = newFormattedText.replaceAll("( begin | end program|\nend program| end if | end if\n|\nend if |\nend if\n| end method | end method\n|\nend method |\nend method\n| if|then|else|while|repeat|method|return(s)?)", TextFormatting.BLUE + "$1" + TextFormatting.WHITE);

        //newFormattedText = newFormattedText.replaceAll("(not|equals|less than|greater than|or|and)", TextFormatting.YELLOW + "$1" + TextFormatting.WHITE);
        //newFormattedText = newFormattedText.replaceAll("(number|Coordinates|string|bool|Collection<(.*?)>)", TextFormatting.LIGHT_PURPLE + "$1" + TextFormatting.WHITE);
        //newFormattedText = newFormattedText.replaceAll("\"(.*?)\"", TextFormatting.RED + "\"$1\"" + TextFormatting.WHITE); // Strings
        //newFormattedText = newFormattedText.replaceAll("(true|false)", TextFormatting.RED + "$1" + TextFormatting.WHITE); // Other literals
        //newFormattedText = newFormattedText.replaceAll("(//.*)", TextFormatting.GREEN + "$1" + TextFormatting.WHITE); // Comments

        StringBuffer newFormattedTextWithCursor = new StringBuffer(newFormattedText).insert(_position, _cursorSymbol);
        _formattedText = TextFormatting.WHITE + newFormattedTextWithCursor.toString();
    }

    private static void insert(String content)
    {
        int oldPosition = _position;
        _position += content.length();
        setText(new StringBuffer(_text).insert(oldPosition, content).toString());
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();

        // Draw position string
        this.fontRendererObj.drawString(TextFormatting.WHITE + "Position: " + _position, this.width - 100, 10, 0);

        // Draw line number
        this.fontRendererObj.drawString(TextFormatting.WHITE + "Line Num: " + _lineNumber, this.width - 100, 25, 0);

        // Draw code
        this.fontRendererObj.drawSplitString( _formattedText, 10, 10, 400, 0);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {
        updateScreen();
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    private void setPositionSafe(int newPosition)
    {
        if (newPosition < 0)
            newPosition = 0;
        else if (newPosition > _text.length() - 1)
            newPosition = _text.length() - 1;

        _position = newPosition;
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (keyCode == KEY_ESCAPE) // Close the GUI
            this.mc.displayGuiScreen(null); // Displaying null hides the GUI screen
        else if (keyCode == KEY_RETURN) // Newline
            insert("\n");
        else if (keyCode == KEY_TAB) // Tab (creates two spaces)
            insert("  ");
        else if (keyCode == KEY_LEFT && _position > 0) // Change position to left
        {
            _position--;
            setText(_text);
        }
        else if (keyCode == KEY_RIGHT && _position < _text.length() - 1)
        {
            _position++;
            setText(_text);
        }
        else if (keyCode == KEY_DELETE && !_text.isEmpty() && _position < _text.length() - 1)
            setText(new StringBuffer(_text).deleteCharAt(_position + 1).toString());
        else if (keyCode == KEY_BACK && !_text.isEmpty() && _position > 0)
        {
            _position--;
            setText(new StringBuffer(_text).deleteCharAt(_position).toString());
        }
        else if (keyCode ==  KEY_DOWN)
        {
            String textAfter = _text.substring(_position);
            int newLinePosition = textAfter.indexOf("\n");
            if (newLinePosition != -1)
            {
                setPositionSafe(_position + newLinePosition + 1);
                setText(_text);
            }
        }
        else if (keyCode == KEY_UP)
        {
            String textBefore = _text.substring(0, _position);
            setPositionSafe(textBefore.lastIndexOf("\n") - 1);
            setText(_text);
        }
        else if (isKeyDown(KEY_LCONTROL))
        {
            if (keyCode == KEY_S) // Save file
                CompilerMod.NETWORK_INSTANCE.sendToServer(new MessageSaveFile(_fileName, _text));
        }
        else if (ChatAllowedCharacters.isAllowedCharacter(typedChar))
            insert(String.valueOf(typedChar));
        else
            System.out.println("Key code:" + keyCode);
    }

    public static void resetPosition()
    {
        _position = 0;
    }
}