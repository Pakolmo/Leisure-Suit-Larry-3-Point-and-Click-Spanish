;;; Sierra Script 1.0 - (do not remove this comment)
(script# 480)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm480 0
)

(local
	local0
	[local1 200]
)
(procedure (localproc_000c &tmp temp0)
	(proc255_0
		@local1
		67
		10
		10
		80
		{Patti dice...}
		70
		140
		30
		1
		25
		(= temp0 (proc0_25 @local1))
		88
	)
	(return (+ 3 temp0))
)

(procedure (localproc_0042 &tmp temp0)
	(proc255_0
		@local1
		67
		160
		10
		80
		{Dices...}
		70
		140
		30
		1
		25
		(= temp0 (proc0_25 @local1))
		88
	)
	(return (+ 3 temp0))
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

(instance rm480 of Rm
	(properties
		picture 480
		south 470
	)
	
	(method (init)
		(gTheMusic fade:)
		(Load rsSCRIPT 969)
		(if (gEgo has: 13)
			(Load rsPIC 99)
			(Load rsVIEW 481)
			(Load rsSOUND 480)
			(Load rsSOUND 481)
			(Load rsSOUND 483)
		else
			(Load rsSOUND 9)
		)
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(aWine init:)
		(aDoor init:)
		(aPanties init:)
		(aBra init:)
		(aPantyhose init:)
		(aDress init:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(aPatti init:)
		(proc0_1)
		(proc0_3)
		(gEgo posn: 159 188 loop: 3 observeControl: 16384 init:)
		(if (gEgo has: 13)
			(RoomScript changeState: 1)
		else
			(RoomScript changeState: 43)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (>= state 10) (gGame setSpeed: 6))
	)
	
	(method (changeState newState &tmp gEgoX gEgoY)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0)
			(1 (= seconds 3))
			(2
				(if (proc0_22 66)
					(proc255_0 480 14)
				else
					(proc255_0 480 15)
				)
				(= seconds 3)
			)
			(3
				(if (proc0_22 66)
					(proc255_0 480 16)
				else
					(proc0_19 66)
					(proc255_0 480 17)
				)
				(= gGNumber_2 0)
				(proc0_1)
				(gEgo observeControl: 16384)
			)
			(4
				(proc0_3)
				(proc0_6)
				(gGame changeScore: 500)
				(proc255_0 480 18)
				(self cue:)
			)
			(5
				(cond 
					((>= (gEgo y?) 140) (= gEgoX 158) (= gEgoY 140))
					((& (gEgo onControl: 1) $0800) (= gEgoX (gEgo x?)) (= gEgoY 140) (-- state))
					((& (gEgo onControl: 1) $1000) (= gEgoX (gEgo x?)) (= gEgoY 140) (-- state))
					((& (gEgo onControl: 1) $0200)
						(= gEgoX 95)
						(if (> (gEgo x?) 95)
							(= gEgoY (gEgo y?))
						else
							(= gEgoY 120)
						)
						(-- state)
					)
					((& (gEgo onControl: 1) $0400)
						(= gEgoX 231)
						(if (< (gEgo x?) 231)
							(= gEgoY (gEgo y?))
						else
							(= gEgoY 120)
						)
						(-- state)
					)
					(else (proc255_0 480 19))
				)
				(gEgo setMotion: MoveTo gEgoX gEgoY self)
			)
			(6
				(proc0_24 13 484)
				((Inv at: 13) view: 28)
				(Format ((Inv at: 13) name?) 480 20)
				(gEgo loop: 3)
				(aWine setCel: 4 stopUpd:)
				(= cycles 11)
			)
			(7
				(gEgo setMotion: MoveTo 194 140 self)
			)
			(8
				(gEgo setMotion: MoveTo 194 132 self)
			)
			(9
				(= global101 (gGame setSpeed: 6))
				(gTheMusic number: 480 loop: -1 play:)
				(SL disable:)
				(TheMenuBar hide: state: 0)
				(proc0_19 5)
				(proc0_19 4)
				(Format @local1 480 21)
				(= seconds (localproc_0042))
				(gEgo loop: 2)
				(Display 480 22 dsCOORD 0 180 dsCOLOR 4 dsFONT global22)
			)
			(10
				(gEgo
					posn: 176 92
					cycleSpeed: 1
					view: 481
					setPri: 8
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(11
				(Format @local1 480 23)
				(= seconds (localproc_000c))
			)
			(12
				(Format @local1 480 24)
				(= seconds (localproc_0042))
			)
			(13
				(Format @local1 480 25)
				(= seconds (localproc_000c))
			)
			(14
				(gEgo loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(15
				(aWine setCel: 3 stopUpd:)
				(gEgo setCycle: End self)
			)
			(16
				(Format @local1 480 26)
				(= seconds (localproc_0042))
				(gEgo loop: 2 cel: 0 setCycle: Fwd)
			)
			(17
				(Format @local1 480 27)
				(= seconds (localproc_000c))
				(gEgo loop: 3 cel: 0 setCycle: Fwd)
			)
			(18
				(aPatti setCycle: End)
				(gEgo loop: 4 cel: 0 setCycle: CT 5 1 self)
			)
			(19
				(aWine setCel: 2 stopUpd:)
				(gEgo setCycle: End self)
			)
			(20
				(aPatti loop: 1 cel: 0)
				(aWine setCel: 1 stopUpd:)
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(21
				(aPatti setCycle: End)
				(gEgo view: 483 loop: 0 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(22
				(aPatti setCycle: Beg)
				(gEgo setCycle: Beg)
				(= cycles 22)
				(if (> 3 (++ local0)) (= state (- state 2)))
			)
			(23
				(Format @local1 480 28)
				(= seconds (- (localproc_0042) 1))
			)
			(24
				(Format @local1 480 29)
				(= seconds (localproc_000c))
				(gEgo hide:)
				(aPatti loop: 2 cel: 0 setCycle: End)
				(gTheMusic number: 481 loop: 2 play:)
			)
			(25
				(aPatti setCycle: CT 3 -1)
				(= cycles 22)
			)
			(26
				(Format @local1 480 30)
				(= seconds (localproc_0042))
			)
			(27
				(Format @local1 480 31)
				(= seconds (localproc_000c))
			)
			(28
				(aPatti setCycle: End)
				(= cycles 44)
			)
			(29
				(aPatti setCycle: CT 3 -1)
				(= cycles 8)
			)
			(30
				(Format @local1 480 32)
				(= seconds (localproc_000c))
			)
			(31
				(Format @local1 480 33)
				(= seconds (localproc_0042))
			)
			(32
				(aPatti loop: 3 cel: 0 setCycle: End)
				(= cycles 33)
			)
			(33
				(global2 drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(gTheWindow color: 12 back: 8)
				(gTheMusic number: 483 loop: 2 play:)
				(= cycles 30)
			)
			(34
				(Format @local1 480 34)
				(= seconds (localproc_000c))
			)
			(35
				(Format @local1 480 35)
				(= seconds (localproc_000c))
			)
			(36
				(Format @local1 480 36)
				(= seconds (- (localproc_000c) 1))
			)
			(37
				(Format @local1 480 37)
				(= seconds (- (localproc_000c) 1))
			)
			(38
				(Format @local1 480 38)
				(= seconds (- (localproc_000c) 1))
			)
			(39
				(Format @local1 480 39)
				(= seconds (- (localproc_000c) 2))
			)
			(40
				(Format @local1 480 40)
				(= seconds (- (localproc_000c) 2))
			)
			(41
				(Format @local1 480 41)
				(proc255_0 @local1 25 (proc0_25 @local1))
				(Format @local1 480 42)
				(proc255_0 @local1 25 (proc0_25 @local1))
				(= seconds (+ 3 (proc0_25 @local1)))
			)
			(42 (global2 newRoom: 481))
			(43
				(gEgo setMotion: MoveTo (gEgo x?) 180 self)
			)
			(44
				(proc255_0 480 43 67 10 5 70 290)
				(proc255_0 480 44 67 -1 144)
				(= seconds 3)
			)
			(45
				(proc255_0 480 45 67 10 5 70 290)
				(gTheMusic number: 9 loop: 1 play: self)
				(proc255_4 480 46 global170)
			)
			(46
				(gEgo setMotion: MoveTo (gEgo x?) 192)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent claimed?) 0)
				(== (pEvent message?) KEY_F8)
				(>= state 9)
			)
			(proc255_0 480 0)
			(proc0_19 69)
			(global2 newRoom: 484)
		)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'make/enjoy')
					(Said 'bang')
					(Said 'go,(climb<in,on),(get<in)/bed')
					(Said 'naked')
					(Said 'get/naked')
					(Said 'drain,give,backdrop/beer')
					(Said 'wear/nothing')
				)
				(if
					(and
						(not (& (gEgo onControl: 1) $0200))
						(not (& (gEgo onControl: 1) $0400))
						(not (& (gEgo onControl: 1) $0800))
						(not (& (gEgo onControl: 1) $1000))
					)
					(proc0_10)
				else
					(self changeState: 4)
				)
			)
			((Said 'address') (proc255_0 480 1))
			((Said 'open/door') (proc255_0 480 2))
			((Said 'get') (proc255_0 480 3))
			((Said 'look>')
				(cond 
					((Said '/balcony,camp,bay,air,cup') (proc255_0 480 4))
					((Said '/bed') (proc255_0 480 5))
					((Said '/entertainer,babe') (proc255_0 480 6))
					((Said '/cloth') (proc255_0 480 7))
					((Said '/keyboard') (proc255_0 480 8))
					((Said '/binocular') (proc255_0 480 9))
					((Said '/burn') (proc255_0 480 10))
					((Said '/bush') (proc255_0 480 11))
					((Said '/buffet') (proc255_0 480 12))
					((Said '[/area]') (proc255_0 480 13))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(or
						(proc0_26 aPanties (pEvent x?) (pEvent y?))
						(proc0_26 aBra (pEvent x?) (pEvent y?))
						(proc0_26 aPantyhose (pEvent x?) (pEvent y?))
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 480 7))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 4)
						(< (pEvent x?) 58)
						(> (pEvent y?) 98)
						(< (pEvent y?) 155)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 480 12))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 150)
						(< (pEvent x?) 177)
						(> (pEvent y?) 112)
						(< (pEvent y?) 134)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(13
							(if
								(and
									(not (& (gEgo onControl: 1) $0200))
									(not (& (gEgo onControl: 1) $0400))
									(not (& (gEgo onControl: 1) $0800))
									(not (& (gEgo onControl: 1) $1000))
								)
								(proc0_10)
							else
								(= gGCursorNumber 900)
								(gGame setCursor: 998 (HaveMouse))
								(self changeState: 4)
							)
						)
						(998 (proc255_0 480 12))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 114)
						(< (pEvent x?) 216)
						(> (pEvent y?) 78)
						(< (pEvent y?) 105)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 480 5))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 271)
						(< (pEvent x?) 319)
						(> (pEvent y?) 100)
						(< (pEvent y?) 154)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 480 8))
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aPatti (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 480 6))
						(997 (proc255_0 480 1))
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aPatti of Prop
	(properties
		y 101
		x 151
		view 483
		loop 4
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setPri: 8 stopUpd:)
	)
)
