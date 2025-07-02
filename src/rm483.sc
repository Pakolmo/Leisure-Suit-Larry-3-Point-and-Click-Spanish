;;; Sierra Script 1.0 - (do not remove this comment)
(script# 483)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm483 0
)

(local
	[local0 200]
)
(procedure (localproc_000c &tmp temp0)
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
		(= temp0 (proc0_25 @local0))
		88
	)
	(return (+ 3 temp0))
)

(instance rm483 of Rm
	(properties
		picture 490
	)
	
	(method (init)
		(proc0_3)
		(Load rsSOUND 489)
		(Load rsSOUND 490)
		(Load rsSOUND 491)
		(Load rsSOUND 492)
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(gTheMusic number: 489 loop: 2 play:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(aPatti setPri: 15 init:)
		(gEgo
			get: 12
			illegalBits: 0
			ignoreActors:
			view: 491
			posn: 173 1116
			setPri: 5
			setStep: 1 1
			cycleSpeed: 1
			moveSpeed: 1
			init:
		)
		(gTheWindow color: 7 back: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(gGame setSpeed: 6)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (aPatti setCycle: End self))
			(1 (= seconds 3))
			(2
				(Format @local0 483 1)
				(= seconds (localproc_000c))
				(aPatti cycleSpeed: 2 loop: 1 cel: 0 setCycle: End)
			)
			(3
				(Format @local0 483 2)
				(= seconds (localproc_000c))
			)
			(4
				(Format @local0 483 3)
				(= seconds (localproc_000c))
				(aPatti setCycle: Beg)
			)
			(5
				(aSparkle init: ignoreActors: setCycle: End)
				(= seconds 2)
			)
			(6
				(Format @local0 483 4)
				(= seconds (localproc_000c))
			)
			(7
				(aPatti loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(aPatti stopUpd:)
				(= seconds 3)
			)
			(9
				(aHole0 setPri: 6 ignoreActors: init:)
				(aHole1 setPri: 5 ignoreActors: init:)
				(aHole2 setPri: 4 ignoreActors: init:)
				(= seconds 3)
			)
			(10
				(gEgo posn: 173 116 setMotion: MoveTo 212 116 self)
				(= cycles 11)
			)
			(11
				(gTheMusic number: 490 loop: 2 play:)
				(Format @local0 483 5)
				(localproc_000c)
			)
			(12
				(gEgo setPri: 4 setMotion: MoveTo 212 110 self)
			)
			(13
				(Format @local0 483 6)
				(= seconds (localproc_000c))
				(gEgo setMotion: MoveTo 192 110)
			)
			(14 (= cycles 11))
			(15
				(Format @local0 483 7)
				(= seconds (localproc_000c))
			)
			(16
				(gEgo hide:)
				(aHole0 dispose:)
				(aHole1 dispose:)
				(aHole2 dispose:)
				(aPatti cycleSpeed: 2 setCycle: Beg self)
			)
			(17 (= seconds 3))
			(18
				(gTheMusic number: 491 loop: 2 play:)
				(Format @local0 483 8)
				(= seconds (localproc_000c))
			)
			(19 (= seconds 5))
			(20
				(gTheMusic fade:)
				(gTheWindow color: global105 back: global106)
				(TheMenuBar draw: state: 1)
				(SL enable:)
				(proc0_20 4)
				(proc0_20 5)
				(global2 newRoom: 484)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent claimed?) 0)
				(== (pEvent message?) KEY_F8)
			)
			(proc255_0 483 0)
			(proc0_19 69)
			(global2 newRoom: 484)
		)
	)
)

(instance aPatti of Act
	(properties
		y 189
		x 170
		view 492
		cycleSpeed 1
	)
)

(instance atpTelescope of PV
	(properties
		y 189
		x 160
		view 490
		priority 4
		signal $4000
	)
)

(instance aHole0 of View
	(properties
		y 92
		x 179
		view 490
		loop 1
	)
)

(instance aHole1 of View
	(properties
		y 92
		x 179
		view 490
		loop 1
		cel 1
	)
)

(instance aHole2 of View
	(properties
		y 92
		x 178
		view 490
		loop 1
		cel 2
	)
)

(instance aSparkle of Prop
	(properties
		y 9
		x 216
		view 490
		loop 2
	)
)
