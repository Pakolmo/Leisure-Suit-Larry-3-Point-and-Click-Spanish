;;; Sierra Script 1.0 - (do not remove this comment)
(script# 481)
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
	rm481 0
)

(local
	[local0 200]
)
(procedure (localproc_000c &tmp temp0)
	(proc255_0
		@local0
		67
		0
		70
		70
		125
		25
		(= temp0 (proc0_25 @local0))
		88
	)
	(return (+ 3 temp0))
)

(instance rm481 of Rm
	(properties
		picture 485
		horizon 5
	)
	
	(method (init)
		(proc0_3)
		(Load rsPIC 99)
		(Load rsVIEW 54)
		(Load rsFONT 7)
		(Load rsSOUND 484)
		(Load rsSOUND 485)
		(SL disable:)
		(TheMenuBar hide:)
		(gTheMusic number: 484 loop: 2 play:)
		(super init:)
		(self setScript: RoomScript)
		(aThermometerP setCycle: End init:)
		(aThermometerL setCycle: End init:)
		(gTheWindow color: 7 back: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(User canInput: 0 canControl: 0 mapKeyToDir: 0)
		(gGame setSpeed: 6)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 33))
			(1
				(Format @local0 481 1)
				(= seconds (localproc_000c))
			)
			(2
				(Format @local0 481 2)
				(= seconds (localproc_000c))
			)
			(3
				(Format @local0 481 3)
				(= seconds (localproc_000c))
			)
			(4
				(Format @local0 481 4)
				(= seconds (localproc_000c))
			)
			(5
				(Format @local0 481 5)
				(= seconds (localproc_000c))
			)
			(6
				(global2 drawPic: 99 6)
				(gTheMusic number: 485 loop: 2 play:)
				(aThermometerP setLoop: 1 cycleSpeed: 0 setCycle: Fwd)
				(aThermometerL setLoop: 1 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 55)
			)
			(7
				(proc255_0 481 6 33 7 67 0 90 70 125 25 3 88)
				(aThermometerP
					setLoop: 0
					setCel: 255
					cycleSpeed: 2
					setCycle: Beg
				)
				(aThermometerL
					setLoop: 0
					setCel: 255
					cycleSpeed: 2
					setCycle: Beg
				)
				(= cycles 55)
			)
			(8
				(aThermometerP dispose:)
				(aThermometerL dispose:)
				(= cycles 33)
			)
			(9
				(Format @local0 481 7)
				(= seconds (localproc_000c))
			)
			(10 (global2 newRoom: 482))
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent claimed?) 0)
				(== (pEvent message?) KEY_F8)
			)
			(proc255_0 481 0)
			(proc0_19 69)
			(global2 newRoom: 484)
		)
	)
)

(instance aThermometerP of Prop
	(properties
		y 189
		x 181
		view 54
		cycleSpeed 12
	)
)

(instance aThermometerL of Prop
	(properties
		y 54
		x 101
		view 54
		cycleSpeed 12
	)
)
