# mastercloudapp-practica6
Practica 6 - Master clouds Testing

## Draughts
### UML
#### svg
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/svg/lLNBJjj055qpNp5ADWwfhOOLYme1gTLQJIWY9ksk6fnfi6Hxw7YCWoZ_tddOyx27bbMpii-vxtElSrupH5bJ5W1a1Qfh-0cL64xR-vpX3jamn7e8FeEZEQpmWGKp0Fbl3YckiNdROxP5HOCvyDBvNn94Tsx8jA7L8Ccl1j51ukiSPnh2LLF29Ia8DQM8b9UhY-KN-VJjSvB6FAkqZ2dLbWgHRSZQt039LP8c5wlk-SVwwpPUnrTf_tuJRsxNiNoBloSfZm_aY8x37Mchy4orTpG0HOD0DQwnoUdXTD8r2hf-3Va-YXOJrVB8SH559uV5IK-hkMXQ3WN8aGumMLCKdQbf02MajZ43wRN_I56plsTrDvavV2ZGarIoCrYHVPwvuvEIBqd5A2aAJAKrkgiPHHc3oikmSFg4YuAqsXTb6NvWWR7OvdNE21LHyefX-XFnLaVqACwZm8EDs6LZF7F8QzxBQzmDhfiIs-oBMNuxv2YnF1-z_NzhfzjffufHk98yOkvEw2wlk3hle7dkSpZ7z--4mzP6AQaq2Eu8AJ2gUFXMhCrR4WnrtkQuXLD2KRKtso5Lv3Q1RxeSgtdQjpl-3xNjQYpLFB0Av27a0JiuqBUbxqyUamSNVa1TcdkhGr3eDCH6GW5PXlW860gC3-h3RnL1PRVMnVNiWzeMsdKWYDV6rSLhCfJ7DY9XtxVgAvY5eRr5mDueKRgd9eSVr-FGereS2riUjJT-kbyVFsksoC_hPG90xw4JsYhFBDvh5k0SLpl-V_y7">
</p>

#### PlantUML
```PlantUML
@startuml

class Game #white
class State #white {
	+ next()
    + reset()
    + getValue()
}
class Board #white
class Turn #white
class Square #white
class Piece #white
enum Color #white {
    BLACK
    WHITE
}
enum Error #white
enum StateValue #white {
    INITIAL
    IN_MOVEMENT
    IN_RESUME
    EXIT
}

Game *-down-> Board	
Game *-down-> Turn
Board *-down-> "8x8" Square
Square *-down-> "0..1" Piece
Board *-down-> "1..2x12" Piece
Piece *-down-> Color
Turn *-down-> Color
Game ..> Error
State *-down-> StateValue

class Draughts {
    + play()
}

class Logic #white {
    + getController()
}
abstract class Controller #yellow {
    + accept(ControllerVisitor)
}
interface ControllerVisitor #yellow {
    + visit(StartController)
    + visit(PlayController)
    + visit(ResumeController)
}
class StartController #yellow {
    + start()
    + accept(ControllerVisitor)
}
class PlayController #yellow {
    + move(Coordinate, Coordinate)
    + next()
    + accept(ControllerVisitor)
}
class ResumeController #yellow {
    + resume(boolean newGame)
    + accept(ControllerVisitor)
}

abstract class View #orange {
    + interact(Controller)
}
class ConsoleView #orange {
    + interact(Controller)
    + visit(StartController)
    + visit(PlayController)
    + visit(ResumeController)
}
class StartView #orange
class PlayView #orange
class ResumeView #orange
class BoardView #orange

Draughts *-down-> Logic
Draughts *-down-> View
Logic *-down-> State
Logic *-down-> Game
Logic *-down-> ControllerVisitor
View ..> Controller
ControllerVisitor <|-down- View
Controller ..> ControllerVisitor

Controller <|-down- StartController
Controller <|-down- PlayController
Controller <|-down- ResumeController
Controller o--> Game

View ()-- ConsoleView
ConsoleView ..> StartController
ConsoleView ..> PlayController
ConsoleView ..> ResumeController

ConsoleView *-down-> StartView
ConsoleView *-down-> PlayView
ConsoleView *-down-> ResumeView
ConsoleView *-down-> BoardView

PlayView *-down-> PlayController
BoardView *-down-> PlayController

@enduml
```
