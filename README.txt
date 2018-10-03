# Description
The language is designed as a response to the lack of intermediary languages between simple and more complicated languages, which previously has hindered the learning process of newcomers to programming.

During the development of EduCode, it was discovered that object-oriented programming as well as gamification served to ease the understanding and learnability of several programming concepts, especially for adolescents.

Minecraft was chosen as the platform for the programming language and so, through Minecraft, EduCode became a way to code entities and affect the game environment within the world of Minecraft, with the purpose of learning programming concepts and computational thinking.

# Example code
An example of a script which chases and kills sheep.

```
using Math

program Test
  method main()
    repeat while true
      // Walk to random location
      coordinates newCoords = robot.getCoordinates() + (random(-10, 10), random(-10, 10), random(-10, 10))
      robot.say("Walking to " + newCoords)
      robot.walkTo(newCoords)
      wait(2000)

      // Iterate over nearby entities
      foreach Entity nearby in robot.getNearbyEntities()
        if nearby.toString() equals "Sheep" then
          kill(nearby)
          break
        end if
      end foreach
    end repeat
  end method

  method kill(Entity target)
    repeat while target.getHealth() greater than 0
      number distance = round(robot.getDistanceTo(target))
      if robot.getDistanceTo(target) greater than 2 then
        robot.say(target + " is " + distance + " away!")
        robot.walkTo(target.getCoordinates())
      else
        robot.attack(target)
        robot.say("Sheep has " + target.getHealth() + " health!")
      end if

      wait(500)
    end repeat
    robot.say(target + " is now dead!")
  end method
end program
```
