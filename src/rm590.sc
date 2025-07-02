;;; Sierra Script 1.0 - (do not remove this comment)
(script# 590)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm590 0
)

(local
	[local0 88]
	[local88 22]
)
(instance rm590 of Rm
	(properties
		picture 590
	)
	
	(method (init)
		(Load rsVIEW 586)
		(Load rsVIEW 593)
		(Load rsVIEW 594)
		(Load rsSOUND 4)
		(Load rsSOUND 6)
		(Load rsSOUND 486)
		(Load rsPIC 99)
		(User canInput: 0 canControl: 0 mapKeyToDir: 0)
		(super init:)
		(gAddToPics add: atpRope doit:)
		(aLarry init:)
		(aCageBack init:)
		(aCageFront init:)
		(self setScript: RoomScript style: 7)
		((Inv at: 17) view: 33)
		(= global66 801)
		(proc0_1 0 592)
		(gEgo
			ignoreActors:
			illegalBits: 0
			setLoop: 0
			cel: 0
			setPri: 6
			posn: 174 110
			init:
		)
		(proc0_28 110 215 55 112 10)
		(User canControl: 0 canInput: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: End)
				(aLarry setCycle: End)
				(= seconds 2)
			)
			(1
				(proc255_0 590 19 67 10 10 70 140 88)
				(proc255_0 590 20 67 170 10 70 140)
				(proc0_5)
				(gEgo setLoop: 1 setCycle: Fwd)
				(aLarry setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(proc255_0 590 21 67 10 10 70 140 88)
				(proc255_0 590 22 67 170 10 70 140)
				(proc0_5)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
				(aLarry setLoop: 2 cel: 0 setCycle: End self)
			)
			(3)
			(4
				(gEgo view: 593 setLoop: 1 cel: 0 setCycle: End)
				(aLarry hide:)
				(= seconds 4)
			)
			(5 (gEgo setCycle: Beg self))
			(6
				(gEgo view: 592 setLoop: 2 setCel: 255 setCycle: Beg self)
				(aLarry
					view: 591
					setLoop: 2
					setCel: 255
					setCycle: Beg self
					show:
				)
			)
			(7)
			(8
				(gEgo setLoop: 1 setCycle: Fwd)
				(aLarry setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(9
				(gEgo setCel: 0)
				(aLarry setCel: 0)
				(gTheMusic fade:)
				(proc255_0 590 23 67 10 5 70 290)
				(gTheMusic number: 486 loop: -1 play:)
				(proc255_0 590 24 67 -1 10)
				(proc255_0 590 25 67 10 5 70 290)
				(proc255_0 590 26 67 10 5 70 290)
				(proc255_0 590 27 67 10 5 70 290)
				(proc255_0 590 28 67 10 5 70 290)
				(proc255_0 590 29 67 -1 10)
				(proc255_0 590 30 67 -1 10)
				(User canInput: 1)
				(User canControl: 0)
				(proc0_4)
				(gGame setCursor: 998 (HaveMouse))
				(= gCursorNumber 998)
				(= seconds 15)
			)
			(10
				(gTheMusic number: 6 loop: -1 play:)
				(aDoctor init: setCycle: End self)
			)
			(11
				(aDoctor cycleSpeed: 0 setLoop: 2 setCycle: Fwd)
				(= cycles 33)
			)
			(12
				(proc255_0 590 31 67 -1 10)
				(= cycles 33)
			)
			(13
				(aDoctor setLoop: 1)
				(= cycles 33)
			)
			(14
				(aDoctor setLoop: 2)
				(aBubblesFront init:)
				(= cycles 33)
			)
			(15
				(proc255_0 590 32 67 -1 10)
				(gEgo
					view: 593
					cycleSpeed: 3
					setLoop: 2
					cel: 0
					setCycle: End self
				)
				(aLarry hide:)
			)
			(16
				(aBubblesFront setLoop: 3)
				(= seconds 3)
			)
			(17
				(aBubblesFront setLoop: 5)
				(aBubblesRear init:)
				(gEgo view: 593 setLoop: 3 cel: 0 setCycle: End self)
			)
			(18
				(gEgo posn: 164 114 setLoop: 0 setPri: 13)
				(aCageFront hide:)
				(aCageBack hide:)
				(= seconds 3)
			)
			(19
				(aLarry
					posn: 163 53
					view: 590
					setLoop: 6
					setMotion: MoveTo 163 199
					setPri: 14
					show:
				)
				(gEgo cycleSpeed: 0 setMotion: MoveTo 164 161 self)
			)
			(20
				(gEgo setMotion: MoveTo 164 231)
				(aDoctor
					setLoop: 0
					setCel: 255
					cycleSpeed: 1
					setCycle: Beg
				)
				(= seconds 5)
			)
			(21
				(aDoctor hide:)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 595
					register: (Format @local0 590 33)
					next: (Format @local88 590 34)
				)
			)
			(22)
			(23
				(proc0_3)
				(proc0_6)
				(gGame changeScore: 500)
				(proc255_0 590 35 67 10 5 70 290)
				(aLarry loop: 1 cel: 0 stopUpd:)
				(= cycles (= seconds 0))
				(gEgo
					cycleSpeed: 1
					view: 594
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(24
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(25
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(26
				(aBubblesFront
					init:
					view: 594
					setLoop: 5
					cel: 0
					cycleSpeed: 0
					setPri: 8
					posn: 169 72
					setCycle: Fwd
				)
				(gEgo setCycle: Beg self)
			)
			(27
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(28
				(aBubblesRear
					init:
					view: 594
					setLoop: 6
					cel: 0
					cycleSpeed: 1
					setPri: 5
					posn: 169 72
					setCycle: End self
				)
				(gEgo setCycle: Beg self)
			)
			(29)
			(30
				(aBubblesRear stopUpd:)
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg)
				(= seconds 3)
			)
			(31
				(proc255_0 590 36 67 10 5 70 290)
				(proc255_0 590 37 67 10 5 70 290)
				(= cycles 22)
			)
			(32
				(proc255_0 590 38 67 10 5 70 290)
				(= cycles 22)
			)
			(33
				(gEgo hide:)
				(aBubblesRear
					cycleSpeed: 1
					setLoop: 4
					cel: 0
					setCycle: End self
				)
			)
			(34
				(Format @local0 590 39 global170)
				(proc255_0 @local0 67 -1 10)
				(gTheSoundFX number: 4 loop: 1 play:)
				(proc255_0 590 40 67 -1 10)
				(= cycles 11)
			)
			(35
				(aLarry
					cycleSpeed: 0
					moveSpeed: 0
					view: 594
					setLoop: 7
					cel: 0
					setCycle: Fwd
					setStep: 2 2
					setPri: 10
					posn: 188 104
					setMotion: MoveTo 156 104 self
				)
			)
			(36
				(aLarry hide:)
				(aBubblesRear
					view: 594
					setLoop: 8
					cel: 0
					setCycle: End self
				)
			)
			(37
				(gTheMusic stop:)
				(gTheSoundFX number: 4 loop: 1 play:)
				(aBubblesRear setLoop: 6 setCel: 255 setCycle: Beg self)
			)
			(38
				(aBubblesFront hide:)
				(= cycles 22)
			)
			(39
				(global2 drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(40 (global2 newRoom: 600))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
			(or (Said 'draw,make/door') (Said 'draw,use/marker'))
				(if (not (gEgo has: 18))
					(proc255_0 590 0)
				else
					(self changeState: 23)
				)
			)
			((Said 'throw,make,use/magic,spell')
				(if (gEgo has: 18)
					(proc255_0 590 1)
				else
					(proc255_0 590 2)
				)
			)
			((Said 'unfasten,grab,carve/hemp,bamboo') (proc255_0 590 3))
			((Said 'throw') (proc255_0 590 4))
			((Said 'use') (proc255_0 590 5))
			((Said 'get') (proc255_0 590 6))
			((or (Said 'enjoy') (Said '/enjoy')) (proc255_0 590 7))
			((Said 'bend/bar') (proc255_0 590 8))
			((Said 'attack') (proc255_0 590 9))
			((Said 'throw,drag/cage') (proc255_0 590 10))
			((Said 'look>')
				(cond 
					((Said '/hemp') (proc255_0 590 11))
					((Said '/man,larry') (proc255_0 590 12))
					(
					(and (gCast contains: aDoctor) (Said '/cannibal')) (proc255_0 590 13))
					((Said '/camp') (proc255_0 590 14))
					((Said '/cage,bar') (proc255_0 590 15))
					((Said '/dope') (proc255_0 590 16))
					((Said '/bamboo,cage') (proc255_0 590 17))
					((Said '[/area]') (proc255_0 590 18))
				)
			)
			((== (pEvent type?) evMOUSEBUTTON)
				(if (& (pEvent modifiers?) emSHIFT)
					(if (== gCursorNumber 992)
						(pEvent claimed: 1)
						(gGame setCursor: 998 (HaveMouse))
						(= gCursorNumber 998)
					)
					(if (== gCursorNumber 999) (pEvent claimed: 1))
					(switch gCursorNumber
						(gGCursorNumber
							(gGame setCursor: 998 (HaveMouse))
							(pEvent claimed: 1)
						)
						(991
							(gGame setCursor: 998 (HaveMouse))
							(pEvent claimed: 1)
						)
						(992
							(gGame setCursor: 998 (HaveMouse))
							(= gCursorNumber 998)
							(pEvent claimed: 1)
						)
						(999
							(gGame setCursor: 998 (HaveMouse))
							(pEvent claimed: 1)
						)
						(993
							(gGame setCursor: 996 (HaveMouse))
							(pEvent claimed: 1)
						)
						(996
							(gGame setCursor: 994 (HaveMouse))
							(pEvent claimed: 1)
						)
						(998
							(gGame setCursor: 995 (HaveMouse))
							(pEvent claimed: 1)
						)
						(995
							(gGame setCursor: 996 (HaveMouse))
							(pEvent claimed: 1)
						)
						(994
							(if
								(or
									(== gGCursorNumber 900)
									(== gGCursorNumber 994)
									(== gGCursorNumber 666)
									(== gGCursorNumber 992)
									(== gGCursorNumber 993)
									(== gGCursorNumber 999)
								)
								(gGame setCursor: 998 (HaveMouse))
							else
								(gGame setCursor: gGCursorNumber (HaveMouse))
								(= gCursorNumber gGCursorNumber)
							)
							(pEvent claimed: 1)
						)
					)
				else
					(if (== gCursorNumber 999)
						(gGame setCursor: 998 (HaveMouse))
						(pEvent claimed: 1)
					)
					(if (== gCursorNumber 992)
						(pEvent claimed: 1)
						(gGame setCursor: 998 (HaveMouse))
						(= gCursorNumber 998)
						(switch gCursorNumber
							(gGCursorNumber
								(gGame setCursor: 998 (HaveMouse))
								(pEvent claimed: 1)
							)
							(991
								(gGame setCursor: 998 (HaveMouse))
								(pEvent claimed: 1)
							)
							(992
								(gGame setCursor: 998 (HaveMouse))
								(= gCursorNumber 998)
								(pEvent claimed: 1)
							)
							(999
								(gGame setCursor: 998 (HaveMouse))
								(= gCursorNumber 998)
								(pEvent claimed: 1)
							)
							(993
								(gGame setCursor: 996 (HaveMouse))
								(pEvent claimed: 1)
							)
							(996
								(gGame setCursor: 994 (HaveMouse))
								(pEvent claimed: 1)
							)
							(998
								(gGame setCursor: 995 (HaveMouse))
								(pEvent claimed: 1)
							)
							(995
								(gGame setCursor: 996 (HaveMouse))
								(pEvent claimed: 1)
							)
							(994
								(if
									(or
										(== gGCursorNumber 900)
										(== gGCursorNumber 994)
										(== gGCursorNumber 666)
										(== gGCursorNumber 992)
										(== gGCursorNumber 993)
										(== gGCursorNumber 999)
									)
									(gGame setCursor: 991 (HaveMouse))
								else
									(gGame setCursor: gGCursorNumber (HaveMouse))
									(= gCursorNumber gGCursorNumber)
								)
								(pEvent claimed: 1)
							)
						)
					)
					(if
						(and
							(> (pEvent x?) 110)
							(< (pEvent x?) 215)
							(> (pEvent y?) 55)
							(< (pEvent y?) 112)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(18 (self changeState: 23))
							(998 (proc255_0 590 17))
							(else  (pEvent claimed: 0))
						)
					)
				)
			)
		)
	)
)

(instance atpRope of PV
	(properties
		y 53
		x 163
		view 590
		loop 6
		priority 2
		signal $4000
	)
)

(instance aCageFront of View
	(properties
		y 114
		x 164
		view 590
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 12 ignoreActors: stopUpd:)
	)
)

(instance aCageBack of View
	(properties
		y 114
		x 164
		view 590
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setPri: 4 stopUpd:)
	)
)

(instance aBubblesFront of Prop
	(properties
		y 160
		x 203
		view 590
		loop 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd ignoreActors:)
	)
)

(instance aBubblesRear of Prop
	(properties
		y 160
		x 203
		view 590
		loop 4
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 setCycle: Fwd ignoreActors:)
	)
)

(instance aLarry of Act
	(properties
		y 110
		x 173
		view 591
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 illegalBits: 0 ignoreActors:)
	)
)

(instance aDoctor of Prop
	(properties
		y 72
		x 288
		view 586
		cycleSpeed 1
	)
)
