;;; Sierra Script 1.0 - (do not remove this comment)
(script# 482)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm482 0
)

(local
	[local0 222]
)
(instance aWine of View
	(properties
		y 115
		x 162
		view 480
		loop 4
		cel 3
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 setCel: 3 ignoreActors: stopUpd:)
	)
)

(instance aDoor of Prop
	(properties
		y 65
		x 159
		view 480
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 3 ignoreActors: stopUpd:)
	)
)

(instance aPanties of View
	(properties
		y 131
		x 63
		view 480
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aBra of View
	(properties
		y 131
		x 63
		view 480
		loop 1
		cel 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aPantyhose of View
	(properties
		y 141
		x 63
		view 480
		loop 1
		cel 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aDress of Prop
	(properties
		y 107
		x 39
		view 480
		loop 2
	)
	
	(method (init)
		(super init:)
		(self
			setPri: 11
			setCel: (if (proc0_23 17 484) 0 else 255)
			ignoreActors:
			stopUpd:
		)
	)
)

(instance atpTelescope of PV
	(properties
		y 50
		x 160
		view 480
		loop 3
		priority 1
		signal $4000
	)
)

(instance rm482 of Rm
	(properties
		picture 480
	)
	
	(method (init)
		(proc0_3)
		(Load rsSCRIPT 969)
		(Load rsVIEW 721)
		(Load rsSOUND 486)
		(Load rsSOUND 487)
		(Load rsSOUND 488)
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(gTheMusic number: 486 loop: 2 play:)
		(aWine init: setCel: 1 stopUpd:)
		(aDoor init:)
		(aPanties init:)
		(aBra init:)
		(aPantyhose init:)
		(aDress init:)
		(aBubbleLarry setScript: PrintLarry init:)
		(aBubblePatti setScript: PrintPatti init:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(aPatti init:)
		(gEgo
			ignoreActors:
			illegalBits: 0
			setPri: 8
			view: 484
			loop: 0
			cycleSpeed: 4
			cel: 1
			setCycle: Fwd
			posn: 178 105
			init:
		)
		(gTheWindow color: global105 back: global106)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(gGame setSpeed: 6)
	)
	
	(method (changeState newState &tmp temp0)
		(proc21_1 self newState 1 4)
		(switch (= state newState)
			(0 (= cycles 33))
			(1
				(Format @local0 482 1)
				(PrintLarry cue:)
			)
			(2 (= cycles 22))
			(3
				(Format @local0 482 2)
				(PrintPatti cue:)
			)
			(4 (= cycles 22))
			(5
				(Format @local0 482 3)
				(PrintLarry cue:)
				(aBubblePatti cel: 0 setCycle: End)
			)
			(6
				(aBubblePatti setCycle: Beg)
				(= cycles 22)
			)
			(7
				(Format @local0 482 4)
				(PrintLarry cue:)
			)
			(8 (= cycles 22))
			(9
				(Format @local0 482 5)
				(PrintPatti cue:)
			)
			(10 (= cycles 33))
			(11
				(Format @local0 482 6)
				(= seconds
					(= temp0 (+ 3 (/ (StrLen @local0) global110)))
				)
				(proc255_0 @local0 25 temp0 88)
			)
			(12 (= cycles 33))
			(13
				(Format @local0 482 7)
				(PrintPatti cue:)
			)
			(14 (= cycles 33))
			(15
				(Format @local0 482 8)
				(= seconds
					(= temp0 (+ 3 (/ (StrLen @local0) global110)))
				)
				(proc255_0 @local0 25 temp0 88)
			)
			(16 (= cycles 3))
			(17
				(gTheMusic number: 487 loop: 2 play:)
				(aBubbleLarry cycleSpeed: 0)
				(Format @local0 482 9)
				(PrintLarry cue:)
				(gEgo loop: 2 cel: 0 setCycle: CT 3 1)
			)
			(18 (= cycles 5))
			(19
				(Format @local0 482 10)
				(PrintLarry cue:)
			)
			(20 (= cycles 5))
			(21
				(Format @local0 482 11)
				(PrintLarry cue:)
				(gEgo setCycle: End)
			)
			(22 (= cycles 22))
			(23
				(gEgo loop: 3 setCycle: End)
				(= cycles 44)
			)
			(24
				(Format @local0 482 12)
				(PrintLarry cue:)
			)
			(25 (= cycles 22))
			(26
				(gEgo
					posn: 188 95
					setLoop: 4
					setCycle: Fwd
					setStep: 1 1
					cycleSpeed: 0
					setMotion: MoveTo 193 90 self
				)
			)
			(27
				(gEgo
					posn: 196 103
					view: 721
					setLoop: 0
					setCel: 255
					setPri: -1
					cycleSpeed: 1
				)
				(= cycles 6)
			)
			(28 (gEgo setCycle: Beg self))
			(29 (= cycles 11))
			(30
				(proc0_1 0 720)
				(proc0_3)
				(gEgo setMotion: MoveTo 231 (gEgo y?) self)
			)
			(31
				(gEgo setMotion: MoveTo 231 120 self)
			)
			(32
				(gEgo setMotion: MoveTo 160 188 self)
			)
			(33
				(gEgo setMotion: MoveTo 160 260 self)
			)
			(34
				(aPatti cycleSpeed: 1 loop: 2 cel: 0 setCycle: End)
				(= cycles 33)
			)
			(35
				(aPatti setCycle: CT 7 -1)
				(= cycles 22)
			)
			(36
				(aPatti setCycle: End)
				(= cycles 22)
			)
			(37
				(aPatti setCycle: CT 7 -1 self)
			)
			(38 (aPatti setCycle: End self))
			(39
				(aPatti cycleSpeed: 0 setCycle: CT 7 -1 self)
			)
			(40 (aPatti setCycle: End self))
			(41
				(gTheMusic number: 488 loop: 2 play:)
				(aPatti posn: 155 98 setLoop: 3 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(42
				(aBubblePatti cycleSpeed: 0)
				(Format @local0 482 13)
				(PrintPatti cue:)
			)
			(43 (= cycles 11))
			(44
				(Format @local0 482 14)
				(PrintPatti cue:)
			)
			(45 (= cycles 33))
			(46
				(Format @local0 482 15)
				(PrintPatti cue:)
			)
			(47 (= cycles 33))
			(48
				(Format @local0 482 16)
				(PrintPatti cue:)
			)
			(49
				(aPatti
					posn: 154 97
					cycleSpeed: 0
					setLoop: 4
					cel: 0
					setCycle: End self
					setMotion: MoveTo 148 89 self
				)
			)
			(50 (= cycles 1))
			(51
				(aPatti
					posn: 143 84
					setPri: -1
					setLoop: 5
					cel: 0
					setCycle: End self
				)
			)
			(52
				(aPatti
					posn: 143 84
					view: 482
					setLoop: -1
					loop: 3
					setCycle: Walk
					setMotion: MoveTo 159 65 self
				)
			)
			(53 (aDoor setCycle: End self))
			(54
				(aDoor stopUpd:)
				(aPatti setMotion: MoveTo 159 55 self)
			)
			(55 (global2 newRoom: 483))
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent claimed?) 0)
				(== (pEvent message?) KEY_F8)
			)
			(proc255_0 482 0)
			(proc0_19 69)
			(global2 newRoom: 484)
		)
	)
)

(instance PrintLarry of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 2 4)
		(switch (= state newState)
			(0)
			(1
				(aBubbleLarry cel: 0 setCycle: End self)
			)
			(2
				(proc255_0
					@local0
					67
					10
					5
					70
					290
					30
					1
					25
					(= seconds (proc0_25 @local0))
					88
				)
			)
			(3
				(aBubbleLarry setCycle: Beg)
				(= state 0)
				(RoomScript cue:)
			)
		)
	)
)

(instance PrintPatti of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 3 4)
		(switch (= state newState)
			(0)
			(1
				(aBubblePatti cel: 0 setCycle: End self)
			)
			(2
				(proc255_0
					@local0
					67
					10
					5
					70
					290
					30
					1
					25
					(= seconds (proc0_25 @local0))
					88
				)
			)
			(3
				(aBubblePatti setCycle: Beg)
				(= state 0)
				(RoomScript cue:)
			)
		)
	)
)

(instance aBubblePatti of Prop
	(properties
		y 82
		x 141
		view 485
		loop 1
		cycleSpeed 1
	)
)

(instance aBubbleLarry of Prop
	(properties
		y 82
		x 179
		view 484
		loop 1
		cycleSpeed 1
	)
)

(instance aPatti of Act
	(properties
		view 485
		cycleSpeed 4
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: posn: 155 98 setPri: 8 setCycle: Fwd)
	)
)
