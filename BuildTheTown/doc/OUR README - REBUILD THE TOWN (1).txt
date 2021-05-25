Rebuild the Town
Authors: Anya Agrawal, Tarini Maram, Joanna Huang
Revision: 05/24/2021


Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?
Our program is an interactive and entertaining game, in which differently shaped blocks fall from the top and the user must place blocks accordingly to complete rows on the grid. Every time a row is completed, it disappears and the user gains blocks to use in the town-building part of the game. Once the placed blocks reach the top of the window, the game ends. The user can then use the blocks to build structures such as houses, towers, and other buildings to help rebuild the town and make it look pretty.


What problem does it solve? Why did you write it?
It is a source of entertainment. We wrote it to provide our users with something to do when they are feeling bored or have nothing else to do. It also helps our users use logical thinking and tests their intelligence. They utilize and develop skills such as quick thinking, rapid decision-making, and spatial knowledge. We wanted to help people find a productive and entertaining way to fill their free time. 


What is the story?
There was a tornado that threw a bunch of blocks into the air, so the player has to arrange them into rows before they fill up the whole place. Once the player has finished doing that, the blocks from the completed rows can be used to build houses in the second part of the game.


What are the rules? What is the goal?
Tetris Rules:
1. You must move the falling block left and right before it lands on the already placed blocks. 
2. As long as you don’t reach the danger line, you can keep playing. In the chance that you do, game over. 
3. The goal is to score as many points as possible by forming rows. The game is never-ending unless the circumstances in rule 2 are met. The incentive is to gain as many points as possible to unlock more blocks to use for the town.
Town Rules:
1. Use blocks collected from the Tetris game to build a town.
2. Keep placing blocks to build houses and buildings until no more blocks are left.
Who would want to use your program?
Our game is entertaining and playable by people of all ages, of all genders, that are from anywhere in the world. People that are bored and want a fun and simple thing to do to pass time would use this program. 


What are the primary features of your program?
The primary features of our program are the falling blocks, moving the blocks, the rows of blocks disappearing, and adding blocks to the user’s inventory based on the points collected. It also includes a building feature in a different area where the player can use the blocks they collected playing Tetris to build houses and other structures in the town.


Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? 
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]


At the start of the game, a Menu will be shown. Once the player clicks the start button, the Tetris game will start and the player will play Tetris. The left and right arrow keys will move it left and right, until the block stops by hitting the floor or another block. After the Tetris game is finished (the blocks reach the danger line), the game will automatically shift to the town building. The mouse left button will add a block to the clicked location and the mouse right button will remove the clicked block.


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
* Blocks falling from the sky with different shapes at speeds that increase as the game goes on
* A way for the player to move blocks to place them how they want to (left and right arrow keys to move blocks)
* Detect if a row is finished and add blocks based on the points collected to the player’s inventory
* An open 2D space where the player has the ability to place the blocks that they have collected by right clicking. They also have the ability to delete blocks by left clicking. 
* Blocks can be placed anywhere in the space, but will fall downwards until they land on another block or the floor.


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
* Adding certain objectives and more guidance as to what the player should build in their town with their blocks 
* Different block colors (possibly some textures?) that the player could choose between when building. 
* A player icon that could move around the town/building space with WASD keys and the window would move to where the player is going (endless space). The player would be able to move past the edge of the window to build more buildings in the town. 
* Sound effects and cool visual effects while playing tetris when multiple rows are completed at the same time or when the player is close to losing (blocks are reaching the top of the window)
* The town/building space would have day and night cycles. 


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
* Making the block placing space (the town) 3D instead of 2D 
* Many different block textures and different types of blocks such as wood, stone, glass, dirt etc. Rarer blocks would have to be collected by completing higher levels of tetris or by completing multiple rows at once. The player would get a random assortment of different types of blocks based on probability and rareness of each type of block as they are playing tetris. 
* A more established storyline where the player had to complete challenges in the town to rebuild and restore it. 


Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]
* Main
* DrawingSurface: PApplet where everything is drawn
* Menu: for GUI, has buttons that “start” the game when the user is ready 
* Tetris: describes rules/functions for the game, has an array of TetrisBlocks, detects when a row is created
* TetrisBlock: several possible shapes, has methods that detect when it is touching another TetrisBlock, draw(), move()
* Town: open space where user can place and delete blocks and build structures, has an array of BuildingBlocks, has 10-second day/night cycles
* BuildingBlock: square block, has methods that detect when it is touching another BuildingBlock, draw(), will possibly have fields for color/texture
* Line: represents a horizontal or vertical line that can move, be rotated, detect intersections
* JBlock, LBlock, SquareBlock, RectangleBlock: Subclasses of tetrisBlock; they differ in the shape they represent as a tetris block 
* Square: all subclasses of tetris block are made up of squares arranged in different orders. This helps us identify when rows are complete and form each tetris block shape. 


Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]


Joanna:
- Building Block, Town, Menu
- UML Diagram, README


Tarini:
- TetrisBlock, Tetris, Line, Square, JBlock, LBlock, RectangleBlock, SquareBlock
- minor help with UML Diagram, README


Anya:
- Main, DrawingSurface, help with Tetris
- presentation for video, help with UML Diagram, README


External Credit:
* Processing library for Graphics
* Tarini’s dad assisted in brainstorming possible approaches to problems. 
* Shelby’s AnimationDemoProcessing project was used for BuildingBlock’s physics
* Stack Overflow for inspiration for possible solutions to some problems.