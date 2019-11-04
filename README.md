# mastercloudapp-practica6
Practica 6 - Master clouds Testing

## Draughts
### UML
#### svg
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/svg/lLPTRzem57skVuK5Bw4iqUXJ7wQgb4KR6fjGeMnxcjpWqKYEtJbEGxNrly-n4tybgtWQJ-RUSp_FkOZhKY0kge80a15Kbl03AZ0Srm-vmArb8v3eJF0tE9j2YeyYcW0eFrF8SOdjjmCMEqGgB0qlRVmDGtplfznMd0P5VbM81uNNESwC2TEgW0j66BUjD2LlLlF59_Nw-d6vJMLLXKmvDqXjKMEetlm4oo_BxNA-Qjy_rglvz-vzcsxkFgVgM_fjkPMvWLhFURndDOslz6XdWR4P3kYXZMrqURmSjKE2TbRhV9iaiv4UjnSuIvABu-oYS-kT6BTQ253h36ogfoIvqfi0caI3iSleU7_FKNLu46MxbIby9EXPiTW2LkoGP_xg5DqBHWLdX62kqEY-51nb0keewuNZPqm8gqqioZByA2ABsELbBXXlikHKOFuJoL5xxbwUfyOURHeTM_34SwxbBF_otUAoAh3hVR72TrFs2glJCSf_RPnMpruNlNG5Uy8odF5zJYKxRw1zdruZdAPNXIj0TCyOmOZAKwuRfPnI8AHsb-CQZXb7z605eOYJc6XeeT9MohAd1_uFWb_lncVlLAmkUIfQdVmWkERos0YD549nOCxKdBAwom5xan3ee_NFFZGs_8UsdW20wg_vFR4kqB_DTtzq1btTaQ4VsILr4IOq87eGu_Cz20bfTq4ixkRMSqMJE7RL2LobDgqFzEJv-_ruxbul7iAbH-jnsDqfSDXhDGU0qQeNwzItolUBEn17mq4DTuuXbD7pG1_M1wuntSi_7dy1">
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
    IN_PLAY
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
class StartView #orange {
    + interact()
}
class PlayView #orange {
    + interact()
}
class ResumeView #orange {
    + interact()
}
class BoardView #orange {
    + writeln(Board)
}

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

PlayView *-down-> PlayController
StartView *-down-> StartController
ResumeView *-down-> ResumeController

ResumeView *-down-> BoardView
PlayView *-down-> BoardView

@enduml
```
