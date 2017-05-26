package com.educode.minecraft.gui;

import java.util.Set;
import java.io.IOException;

import com.educode.helper.ArrayHelper;
import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.networking.MessageSaveFile;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.util.text.TextFormatting;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.BiMap;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;
import static org.lwjgl.input.Keyboard.*;


@SideOnly(Side.CLIENT)
public class GuiProgramEditor extends GuiScreen
{
    private static final ResourceLocation BOOK_GUI_TEXTURES = new ResourceLocation("textures/gui/book.png");

    private static String _text = "";
    private static String _formattedText = "";
    private static String _fileName;
    private static String[] _lines;
    private static int _position = 0;
    private static int _lineNumber = 0;
    private static int _visibleTopLine = 1;
    private static int _visibleBottomLine = 25;
    private static final String _cursorSymbol = "\uFEFF";
    private static final String _cursorSymbolVisible = "|";
    private static int _positionInLine = 0;

    public GuiProgramEditor()
    {
        super();
    }

    public static void setFileName(String name)
    {
        _fileName = name;
    }

    private static String testWords(String[] words, BiMap<TextFormatting, String[]> keyWordMap, String[] partialKeywords)
    {
        boolean buildingString = false;
        boolean buildingFormalParameters = false;
        Tuple<Integer, String[]> keywords;
        String partial = "";

        StringBuilder formattedLine = new StringBuilder();

        for (String word : words)
        {
            if(word.replace(_cursorSymbol, "").contains("//"))
            {
                StringBuilder commentWord = new StringBuilder(word);

                if (words.length == ArrayHelper.indexOfNth(word, words, 1) + 1)
                {
                    commentWord.insert(word.replace(_cursorSymbol,"").indexOf("//"), TextFormatting.GRAY);
                    commentWord.append(TextFormatting.WHITE).append(" ");
                    formattedLine.append(commentWord);
                    continue;
                }

                StringBuilder lastWord = new StringBuilder(words[words.length - 1]);
                commentWord.insert(word.replace(_cursorSymbol,"").indexOf("//"), TextFormatting.GRAY);
                lastWord.insert(lastWord.length(), TextFormatting.WHITE + " ");

                formattedLine.append(commentWord).append(" ");

                for (int j = ArrayHelper.indexOfNth(word, words, 1) + 1; j < words.length - 1; j++)
                {
                    formattedLine.append(words[j]).append(" ");
                }

                formattedLine.append(lastWord);

                return formattedLine.toString();
            }

            if (buildingString)
            {
                if (word.contains("\""))
                {
                    buildingString = false;
                    StringBuilder stringEnd = new StringBuilder(word);
                    stringEnd.insert(word.indexOf("\"") + 1, TextFormatting.WHITE);
                    formattedLine.append(stringEnd).append(" ");
                    continue;
                }
                formattedLine.append(word).append(" ");
                continue;
            }

            if(word.contains("\""))
            {
                buildingString = true;
                StringBuilder stringStart = new StringBuilder(word);
                stringStart.insert(word.indexOf("\""), TextFormatting.RED);

                if (word.lastIndexOf("\"") != word.indexOf("\""))
                {
                    buildingString = false;
                    // + 3 because color code is 2 characters and we insert colorcode after the string: 2+1=3
                    stringStart.insert(ArrayHelper.indexOfNth('\"', word.toCharArray(), 2) + 3, TextFormatting.WHITE);
                }
                formattedLine.append(stringStart).append(" ");
                continue;
            }

            if (buildingFormalParameters)
            {
                if (word.replace(_cursorSymbol, "").contains(")"))
                {
                    buildingFormalParameters = false;
                    formattedLine.append(word);
                    continue;
                }
                keywords = testWord(word.replace(_cursorSymbol, "").replace(")", ""), keyWordMap.get(TextFormatting.AQUA), partialKeywords);

                switch(keywords.getFirst())
                {
                    case 0:
                        formattedLine.append(word + " ");
                        break;
                    case 1:
                        formattedLine.append(TextFormatting.AQUA).append(word).append(TextFormatting.WHITE + " ");
                        break;
                    case 2:
                        formattedLine.append(word + " ");
                        break;
                }
                continue;
            }

            if (word.replace(_cursorSymbol, "").contains("(") && !word.replace(_cursorSymbol, "").contains(")"))
            {
                buildingFormalParameters = true;


                String wordToCheck = word.substring(word.indexOf("(") + 1);
                word = word.replace(wordToCheck, "");

                keywords = testWord(wordToCheck.replace(_cursorSymbol, ""), keyWordMap.get(TextFormatting.AQUA), partialKeywords);

                switch(keywords.getFirst())
                {
                    case 0:
                        formattedLine.append(word).append(wordToCheck + " ");
                        break;
                    case 1:
                        formattedLine.append(word).append(TextFormatting.AQUA).append(wordToCheck + " ").append(TextFormatting.WHITE);
                        break;
                    case 2:
                        formattedLine.append(word).append(wordToCheck + " ");
                        break;
                }
                continue;
            }

            if (word.replace(_cursorSymbol, "").contains("Collection<"))
            {
                String[] collectionCollection = word.split("(<)");

                if(ArrayHelper.characterCountInArray(">", collectionCollection) == collectionCollection.length - 1)
                {
                    StringBuilder finalCollection = new StringBuilder(TextFormatting.AQUA.toString());

                    for (int i = 0; i < collectionCollection.length-1; i++)
                    {
                        finalCollection.append(collectionCollection[i]).append("<");
                    }

                    String type;

                    if (collectionCollection[collectionCollection.length - 1].contains(">" + _cursorSymbol))
                    {
                        type = collectionCollection[collectionCollection.length-1].replace(">", "").replace(_cursorSymbol, "");
                    }
                    else
                    {
                        type = collectionCollection[collectionCollection.length-1].replace(">", "");
                    }
                    keywords = testWord(type.replace(_cursorSymbol, ""), keyWordMap.values(), partialKeywords);



                    switch(keywords.getFirst())
                    {
                        case 0:
                            finalCollection.append(TextFormatting.WHITE).append(type).append(TextFormatting.AQUA);
                            break;
                        case 1:
                            finalCollection.append(type);
                            break;
                        case 2:
                            finalCollection.append(TextFormatting.WHITE).append(type).append(TextFormatting.AQUA);
                            break;
                    }
                    String debug = collectionCollection[collectionCollection.length-1].replace(type, "");

                    finalCollection.append(debug);
                    formattedLine.append(finalCollection).append(TextFormatting.WHITE.toString() + " ");
                    continue;
                }
            }

            if (partial.equals(""))
            {
                keywords = testWord(word.replace(_cursorSymbol, ""), keyWordMap.values(),partialKeywords);
                switch(keywords.getFirst())
                {
                    case 0:
                        formattedLine.append(word).append(" ");
                        break;
                    case 1:
                        TextFormatting col = keyWordMap.inverse().get(keywords.getSecond());
                        formattedLine.append(col).append(word).append(" ").append(TextFormatting.WHITE);
                        break;
                    case 2:
                        partial = word;
                        formattedLine.append(partial).append(" ");
                        break;
                }
            }
            else
            {
                keywords = testWord((partial + " " + word).replace(_cursorSymbol, ""), keyWordMap.values(), partialKeywords);
                switch(keywords.getFirst())
                {
                    case 0:
                        formattedLine.append(word).append(" ");
                        break;
                    case 1:
                        TextFormatting col = keyWordMap.inverse().get(keywords.getSecond());
                        formattedLine.insert(formattedLine.length() - (partial.length() + 1), col);
                        formattedLine.append(word).append(TextFormatting.WHITE).append(" ");
                        partial = "";
                        break;
                    case 2:
                        partial = partial + " " + word;
                        formattedLine.append(partial).append(" ");
                        break;
                }
            }

        }
        return formattedLine.toString();
    }

    private static Tuple<Integer, String[]> testWord(String word, String[] keywords, String[] partialKeywords)
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
        return new Tuple<>(0, null);
    }

    private static Tuple<Integer, String[]> testWord(String word, Set<String[]> keywordSet, String[] partialKeywords) {
        for (String[] keywords : keywordSet)
        {
            for (String keyword : keywords)
            {
                if (word.equals(keyword))
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
        //Highlight keywords
        final String[] partialKeywords = new String[] {"end", "repeat", "less", "greater", "on"};
        final String[] blockKeywords = new String[] {"program", "end program", "method", "end method", "if", "then", "else", "end if", "repeat while", "end repeat", "return", "returns", "foreach", "in", "end foreach"};
        final String[] booleanKeywords = new String[] {"not", "equals", "less than", "greater than", "or", "and"};
        final String[] typeKeywords = new String[] {"number", "Coordinates", "string", "bool", "Item", "Entity"};
        final String[] tfKeywords = new String[] {"true", "false"};
        final String[] eventKeywords = new String[] {"on event", "call"};
        final String[] referenceKeywords = new String[] {"null", "new", "using"};
        final String[] loopKeywords = new String[] {"continue", "break"};
        final String[] events = new String[] {"robotDeath", "robotAttacked", "chatMessage", "entityDeath", "stringMessageReceived", "entityMessageReceived"};

        //Assign colors for above keywords
        BiMap<TextFormatting, String[]> keyWordMap = HashBiMap.create();
        keyWordMap.put(TextFormatting.LIGHT_PURPLE, blockKeywords);
        keyWordMap.put(TextFormatting.GOLD, booleanKeywords);
        keyWordMap.put(TextFormatting.AQUA, typeKeywords);
        keyWordMap.put(TextFormatting.GREEN, tfKeywords);
        keyWordMap.put(TextFormatting.BLUE, eventKeywords);
        keyWordMap.put(TextFormatting.DARK_PURPLE, referenceKeywords);
        keyWordMap.put(TextFormatting.DARK_GREEN, loopKeywords);
        keyWordMap.put(TextFormatting.DARK_AQUA, events);

        //Remove \r from _text as they are unnecessary
        _text = text.replace("\r", "");
        //Insert the cursor
        String textWithCursor = new StringBuffer(_text).insert(_position, _cursorSymbol).toString();
        //Split the text into lines in an array
        _lines = textWithCursor.split("(\n)");

        // setting line number
        for (int i = 0; i <= _lines.length - 1; i++)
        {
            if (_lines[i].contains(_cursorSymbol))
            {
                _lineNumber = i + 1;
                break;
            }
        }

        // calc position in line
        // TODO: There's no reason why cursor symbol should a char, change indexOfNth to support strings
        _positionInLine = _lines[_lineNumber - 1].indexOf(_cursorSymbol) + 1;

        //set visible part of editor for scrolling
        if (_lineNumber < _visibleTopLine)
        {
            _visibleTopLine--;
            _visibleBottomLine--;
        }
        else if (_lineNumber > _visibleBottomLine)
        {
            _visibleTopLine++;
            _visibleBottomLine++;
        }

        StringBuilder newFormattedText = new StringBuilder();

        //Format the text from _text by going through each line and then append it to newFormattedText
        for (String line : ArrayHelper.getSubArray(_visibleTopLine - 1, _visibleBottomLine - 1, _lines))
        {
            newFormattedText.append(testWords(line.split("( )"), keyWordMap, partialKeywords)).append("\n");
        }

        //Add the new formatted text to the text shown on screen
        _formattedText = TextFormatting.WHITE + newFormattedText.toString().replace(_cursorSymbol, _cursorSymbolVisible);
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
        this.fontRendererObj.drawString(TextFormatting.WHITE + "Position: " + _positionInLine, this.width - 100, 10, 0);

        // Draw line number
        this.fontRendererObj.drawString(TextFormatting.WHITE + "Line Num: " + _lineNumber, this.width - 100, 25, 0);

        //this.fontRendererObj.drawString(TextFormatting.WHITE + "Doc Position: " + _position, this.width - 100, 40, 0);

        // Draw code
        this.fontRendererObj.drawSplitString( _formattedText, 10, 10, this.width - 10, 0);

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
        // Check if escape key pressed
        if (keyCode == KEY_ESCAPE) // Close the GUI
        {
            this.mc.displayGuiScreen(null); // Displaying null hides the GUI screen
        }

        // Test if left control is down
        if (isKeyDown(KEY_LCONTROL))
        {
            if (keyCode == KEY_S) // Save file
            {
                CompilerMod.NETWORK_INSTANCE.sendToServer(new MessageSaveFile(_fileName, _text));
                return;
            }
        }

        // Handle based on key
        if (keyCode == KEY_RETURN) // Newline
        {
            int indexOfFirstChar = StringUtils.indexOfAnyBut(_lines[_lineNumber - 1], ' ');

            StringBuffer newLine = new StringBuffer("\n");
            for (int i = 0; i < indexOfFirstChar; i++)
            {
                newLine.append(" ");
            }
            insert(newLine.toString());
        }
        else if (keyCode == KEY_TAB) // Tab (creates two spaces)
            insert("  ");
        else if (keyCode == KEY_LEFT && _position > 0) // Change position to left
        {
            _position--;
            setText(_text);
        }
        else if (keyCode == KEY_RIGHT && _position < _text.length())
        {
            _position++;
            setText(_text);
        }
        else if (keyCode == KEY_DELETE && !_text.isEmpty() && _position < _text.length() - 1)
            setText(new StringBuffer(_text).deleteCharAt(_position).toString());
        else if (keyCode == KEY_BACK && !_text.isEmpty() && _position > 0)
        {
            _position--;
            setText(new StringBuffer(_text).deleteCharAt(_position).toString());
        }
        else if (keyCode ==  KEY_DOWN)
        {
            if (_lineNumber != _lines.length)
            {
                if (_lines[_lineNumber].length() <= _positionInLine - 1)
                {
                    setPositionSafe(_position + (_lines[_lineNumber - 1].length() - _positionInLine) + _lines[_lineNumber].length() + 1);
                }
                else
                {
                    setPositionSafe(_position + _lines[_lineNumber - 1].length());
                }
                setText(_text);
            }
        }
        else if (keyCode == KEY_UP)
        {
            if (_lineNumber != 1)
            {
                if (_lines[_lineNumber - 2].length() <= _positionInLine - 1)
                {
                    setPositionSafe(_position - _positionInLine);
                }
                else
                {
                    setPositionSafe(_position - _lines[_lineNumber - 2].length() - 1);
                }
                setText(_text);
            }
        }
        else if (ChatAllowedCharacters.isAllowedCharacter(typedChar))
            insert(String.valueOf(typedChar));
        else
            System.out.println("Key char:" + typedChar);
    }

    public static void resetPosition()
    {
        _position = 0;
        _lineNumber = 1;
        _positionInLine = 1;
        _visibleTopLine = 1;
        _visibleBottomLine = 25;
    }
}