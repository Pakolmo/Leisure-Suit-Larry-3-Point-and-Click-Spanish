;;; Sierra Script 1.0 - (do not remove this comment)
(script# 355)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm355 0
)

(instance rm355 of Rm
	(properties
		picture 355
	)
	
	(method (init)
		(Load rsVIEW 352)
		(Load rsVIEW 356)
		(super init:)
		(gAddToPics
			add: atpComputer
			add: atpPaper
			add: atpPhone
			add: atpSign
			doit:
		)
		(if (> global87 16)
			(aFountain setCycle: Fwd isExtra: 1 init:)
		)
		(aKen init:)
		(gEgo illegalBits: 0 posn: 290 141 init:)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 214 146 self)
				(= cycles 22)
			)
			(1 (aKen setCycle: Fwd))
			(2
				(proc255_0 355 0)
				(aKen setCel: 0)
				(gEgo setMotion: MoveTo 269 165 self)
				(= cycles 22)
			)
			(3 (aKen setCycle: Fwd))
			(4
				(proc255_0 355 1)
				(aKen setCel: 0)
				(gEgo
					view: 356
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 33)
			)
			(5
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(6
				(gEgo loop: 1 cel: 0 setCycle: End)
				(= cycles 33)
			)
			(7
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(8
				(gEgo
					view: global66
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 161 165 self
				)
			)
			(9
				(gEgo setMotion: MoveTo 165 149 self)
			)
			(10
				(gEgo view: 356 loop: 2 cel: 0 setCycle: End self)
			)
			(11
				(gEgo
					cycleSpeed: 1
					setLoop: 3
					cel: 0
					setCycle: End
					setMotion: MoveTo 146 154 self
				)
			)
			(12
				(proc255_0 355 2)
				(= seconds 2)
			)
			(13
				(aKen setCycle: Fwd)
				(= seconds 3)
			)
			(14
				(proc255_0 355 3)
				(aKen viewer: tiradeCycler loop: 1)
				(= seconds 3)
			)
			(15
				(proc255_0 355 4 67 -1 144)
				(= seconds 2)
			)
			(16
				(proc255_0 355 5)
				(aKen loop: 2)
				(= seconds 3)
			)
			(17
				(proc255_0 355 6)
				(proc0_15 gEgo)
				(gEgo
					view: 355
					loop: 3
					posn: (aKen x?) (aKen y?)
					setPri: 5
					stopUpd:
				)
				(proc0_2 aKen 3 352)
				(aKen
					illegalBits: 0
					viewer: 0
					posn: 30 140
					setPri: 3
					setMotion: MoveTo 30 132 self
				)
			)
			(18
				(aKen setMotion: MoveTo 40 128 self)
			)
			(19
				(proc255_0 355 7 67 -1 144)
				(aKen setMotion: MoveTo 109 128 self)
			)
			(20
				(proc255_0 355 8)
				(global2 newRoom: 350)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(asm
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			super    Script,  6
			not     
			bnt      code_040c
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			not     
			bnt      code_040c
			lag      gTheNewDialog
			bnt      code_040c
			pushi    #message
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      13
			eq?     
			bnt      code_03e9
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      4
			eq?     
			bt       code_03f7
code_03e9:
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      1
			eq?     
			bnt      code_040c
code_03f7:
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			pushi    0
			callb    proc0_5,  0
			pushi    #cue
			pushi    0
			self     4
code_040c:
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      1
			eq?     
			bnt      code_0435
			pushi    #modifiers
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      3
			and     
			not     
			bnt      code_0435
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			bnt      code_0435
code_0435:
			ret     
		)
	)
)

(instance aFountain of Prop
	(properties
		y 104
		x 157
		view 350
		loop 3
	)
)

(instance aKen of Act
	(properties
		y 139
		x 33
		view 355
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setPri: 10 stopUpd:)
	)
)

(instance tiradeCycler of Code
	(properties)
	
	(method (doit)
		(if (not (Random 0 4))
			(aKen cycleSpeed: (Random 0 2))
		)
	)
)

(instance atpComputer of PV
	(properties
		y 149
		x 33
		view 355
		loop 4
		priority 11
		signal $4000
	)
)

(instance atpPaper of PV
	(properties
		y 128
		x 67
		view 355
		loop 4
		cel 1
		priority 12
		signal $4000
	)
)

(instance atpPhone of PV
	(properties
		y 124
		x 57
		view 355
		loop 4
		cel 2
		priority 12
		signal $4000
	)
)

(instance atpSign of PV
	(properties
		y 142
		x 63
		view 355
		loop 4
		cel 3
		priority 12
		signal $4000
	)
)
