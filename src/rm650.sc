;;; Sierra Script 1.0 - (do not remove this comment)
(script# 650)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Rev)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm650 0
)

(local
	local0
	local1
	[local2 222]
)
(procedure (localproc_000c param1 &tmp temp0)
	(if (< argc 1) (= param1 200))
	(proc255_0
		@local2
		67
		-1
		10
		70
		param1
		25
		(= temp0 (proc0_25 @local2))
		88
	)
	(return (+ 2 temp0))
)

(instance rm650 of Rm
	(properties
		picture 650
	)
	
	(method (init)
		(proc0_3)
		(Load rsSCRIPT 969)
		(aLeg init:)
		(aMonitor init:)
		(aLeftHand init:)
		(aRightHand init:)
		(aDoor init:)
		(aTheEnd init:)
		(super init:)
		(gAddToPics
			add: atpKeyboard
			add: atpGlass
			add: atpBigGlass
			doit:
		)
		(self setScript: RoomScript)
		(= global101 (gGame setSpeed: 6))
		(proc0_1 6 650)
		(proc0_3)
		(gEgo
			posn: 999 999
			setPri: 15
			setStep: 1 1
			setLoop: 6
			ignoreActors:
			moveSpeed: 2
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(Format @local2 650 0)
				(= seconds (localproc_000c))
			)
			(2
				(Format @local2 650 1)
				(= seconds (localproc_000c))
			)
			(3
				(Format @local2 650 2)
				(= seconds (localproc_000c 122))
			)
			(4
				(Format @local2 650 3)
				(= seconds (localproc_000c 111))
			)
			(5
				(Format @local2 650 4)
				(= seconds (localproc_000c))
			)
			(6
				(Format @local2 650 5)
				(aMonitor hide:)
				(= seconds (localproc_000c))
			)
			(7
				(aMonitor show: setLoop: 5 setCycle: Fwd)
				(aDoor posn: 64 99)
				(gEgo posn: 64 103)
				(= seconds 6)
			)
			(8
				(gEgo setMotion: MoveTo 64 100 self)
			)
			(9 (aDoor setCycle: End self))
			(10
				(gEgo posn: 999 999)
				(= seconds 3)
			)
			(11 (aDoor setCycle: Beg self))
			(12 (= seconds 6))
			(13
				(aMonitor hide:)
				(aDoor posn: 234 345)
				(gEgo posn: 999 999)
				(= seconds 3)
			)
			(14
				(aMonitor show: loop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(15
				(if local1
					(= seconds 7)
					(= state 6)
				else
					(aTheEnd init: setCycle: End self)
				)
			)
			(16
				(aTheEnd setLoop: 1 cycleSpeed: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(17
				(= local1 1)
				(Format @local2 650 6)
				(= seconds (localproc_000c))
			)
			(18
				(Format
					@local2
					{Version Point and Click By: DoomLazer and Pakolmo\nacknowledgements: Kokeween, walas74, Benito Camelo and Stormspirit86}
				)
				(= seconds (localproc_000c))
			)
			(19
				(Format @local2 650 7)
				(= seconds (localproc_000c))
			)
			(20
				(if
					(and
						(proc0_22 11)
						(proc0_22 56)
						(proc0_22 52)
						(proc0_22 43)
						(not (proc0_22 77))
						(not (proc0_22 70))
						(proc0_22 45)
					)
					(Format @local2 650 8)
				else
					(Format @local2 650 9)
				)
				(= seconds (localproc_000c))
			)
			(21
				(if (not (proc0_22 77))
					(self cue:)
				else
					(Format @local2 650 10)
					(= seconds (localproc_000c))
				)
			)
			(22
				(if (proc0_22 43)
					(self cue:)
				else
					(Format @local2 650 11)
					(= seconds (localproc_000c))
				)
			)
			(23
				(if (proc0_22 70)
					(Format @local2 650 12)
					(= seconds (localproc_000c))
				else
					(self cue:)
				)
			)
			(24
				(if (proc0_22 11)
					(self cue:)
				else
					(Format @local2 650 13)
					(= seconds (localproc_000c))
				)
			)
			(25
				(if (not (proc0_22 56))
					(Format @local2 650 14)
					(= seconds (localproc_000c))
				else
					(self cue:)
				)
			)
			(26
				(if (proc0_22 52)
					(self cue:)
				else
					(Format @local2 650 15)
					(= seconds (localproc_000c))
				)
			)
			(27
				(if (proc0_22 45)
					(self cue:)
				else
					(Format @local2 650 16)
					(= seconds (localproc_000c))
				)
			)
			(28 (= state 6))
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (super handleEvent: pEvent))
				(not (pEvent claimed?))
				gTheNewDialog
				seconds
				(== (pEvent message?) KEY_RETURN)
				(== (pEvent type?) evKEYBOARD)
			)
			(pEvent claimed: 1)
			(= seconds 0)
			(proc0_5)
			(self cue:)
		)
	)
)

(instance atpKeyboard of PV
	(properties
		y 189
		x 60
		view 650
		priority 14
	)
)

(instance atpGlass of PV
	(properties
		y 158
		x 221
		view 650
		cel 1
		priority 15
		signal $4000
	)
)

(instance atpBigGlass of PV
	(properties
		y 173
		x 192
		view 650
		cel 2
		priority 15
		signal $4000
	)
)

(instance aRightHand of Prop
	(properties
		y 173
		x 103
		view 650
		loop 1
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd ignoreActors:)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(cond 
			((== (= temp0 (Random 0 33)) 1) (self posn: 100 178))
			((== temp0 2) (self posn: 101 184))
			((== temp0 3) (self posn: 34 180))
			((== temp0 4) (self posn: 36 184))
			((< temp0 17) (self cel: 0))
			(else (self cel: 1))
		)
	)
)

(instance aLeftHand of Prop
	(properties
		y 173
		x 17
		view 650
		loop 2
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd ignoreActors:)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(cond 
			((== (= temp0 (Random 0 33)) 1) (self posn: 11 173))
			((== temp0 2) (self posn: 18 180))
			((== temp0 3) (self posn: 8 185))
			((< temp0 17) (self cel: 0))
			(else (self cel: 1))
		)
	)
)

(instance aMonitor of Prop
	(properties
		y 104
		x 61
		view 650
		loop 3
	)
	
	(method (init)
		(super init:)
		(self setPri: 4 setCycle: Fwd ignoreActors:)
	)
	
	(method (doit)
		(super doit:)
		(if (== loop 3)
			(switch (Random 0 7)
				(1 (self setCycle: Fwd))
				(2 (self setCycle: Rev))
				(3
					(self cycleSpeed: (Random 0 1))
				)
			)
		)
	)
)

(instance aLeg of Prop
	(properties
		y 189
		x 306
		view 650
		loop 4
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
	
	(method (doit)
		(super doit:)
		(switch (Random 0 7)
			(0 (self setCycle: Fwd))
			(7 (self setCel:))
		)
	)
)

(instance aDoor of Prop
	(properties
		y 990
		x 640
		view 650
		loop 7
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 7 ignoreActors:)
	)
)

(instance aTheEnd of Prop
	(properties
		y 47
		x 96
		view 651
	)
)
