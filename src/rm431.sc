;;; Sierra Script 1.0 - (do not remove this comment)
(script# 431)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Jump)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm431 0
)

(local
	local0
	theAActor1
	theAActor2
	theAActor3
	theAActor4
	theAActor5
	local6
	theAActor1_2
	theAActor2_2
	theAActor3_2
	theAActor4_2
	theAActor5_2
	local12 =  999
	local13 =  113
	local14 =  127
	local15 =  141
	[local16 2] = [155 169]
	local18 =  183
	[local19 2] = [197 999]
	[local21 40]
	[local61 22]
)
(instance rm431 of Rm
	(properties
		picture 430
		horizon 1
	)
	
	(method (init &tmp temp0)
		(Load rsSOUND 10)
		(Load rsSOUND 433)
		(Load rsSOUND 432)
		(Load rsSCRIPT 991)
		(Load rsPIC 99)
		(Load rsFONT 7)
		(super init:)
		(self setScript: RoomScript)
		(aCurtain ignoreActors: init:)
		(aActor1 ignoreActors: init:)
		(aActor2 ignoreActors: init:)
		(aActor3 ignoreActors: init:)
		(aActor4 ignoreActors: init:)
		(aActor5 ignoreActors: init:)
		(= global101 (gGame setSpeed: 6))
		(= theAActor1 aActor1)
		(= theAActor2 aActor2)
		(= theAActor3 aActor3)
		(= theAActor4 aActor4)
		(= theAActor5 aActor5)
		(= theAActor1_2 aActor1)
		(= theAActor2_2 aActor2)
		(= theAActor3_2 aActor3)
		(= theAActor4_2 aActor4)
		(= theAActor5_2 aActor5)
		(proc0_1)
		(gEgo
			view: 431
			setLoop: 0
			setCycle: Walk
			setStep: 2 1
			setCycle: Walk
			setPri: 1
			posn: 16 75
			ignoreActors:
			init:
		)
		(proc0_3)
		(RoomScript changeState: 1)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(== -1 (gTheMusic prevSignal?))
				(== (gTheMusic number?) 432)
			)
			(self changeState: 22)
		)
		(if (== gGNumber_2 431)
			(cond 
				((& (gEgo onControl: 1) $0002) (= temp0 1))
				((& (gEgo onControl: 1) $0004) (= temp0 2))
				((& (gEgo onControl: 1) $0008) (= temp0 3))
				((& (gEgo onControl: 1) $0010) (= temp0 4))
				((& (gEgo onControl: 1) $0020) (= temp0 5))
				((& (gEgo onControl: 1) $0040) (= temp0 6))
				(else (= temp0 0))
			)
			(gEgo setLoop: temp0)
			(aFloor
				posn: [local12 temp0] 97
				setCel:
					(aSpotlight
						posn: [local12 temp0] 52
						setCel: (if (< global87 39) (return) else 0)
					)
			)
		)
	)
	
	(method (changeState newState &tmp temp0)
		(proc21_1 self newState 1 12)
		(switch (= state newState)
			(0)
			(1
				(proc255_0 431 4 67 10 5 70 290)
				(aCurtain setCycle: End self)
				(= seconds 3)
			)
			(2)
			(3
				(aCurtain stopUpd:)
				(proc255_0 (Format @local21 431 5 global170) 33 7)
				(proc255_0 431 6)
				(proc255_0 431 7)
				(= seconds 3)
			)
			(4
				(proc255_0 431 8 67 10 5 70 290)
				(proc255_0 431 9)
				(proc255_0 431 10 67 -1 144)
				(= seconds 3)
			)
			(5
				(proc255_0 431 11 67 -1 10)
				(= seconds 3)
			)
			(6
				(proc255_0 431 12 67 -1 10)
				(proc255_0 431 13)
				(gEgo setPri: -1 setMotion: MoveTo 36 95 self)
			)
			(7
				(proc255_0 431 14)
				(= gGNumber_2 432)
				(gGame setCursor: 998 (HaveMouse))
				(proc0_4)
				(User canInput: 1)
				(gTheMusic stop:)
				(gEgo cel: 0)
				(aCurtain setCycle: Beg self)
			)
			(8
				(aCurtain stopUpd:)
				(= seconds 3)
			)
			(9
				(proc255_0 431 15 67 10 5 70 290)
				(= seconds 10)
			)
			(10
				(gTheMusic number: 433 loop: -1 play:)
				(proc255_0 431 16 67 -1 10)
				(proc255_0 431 17 67 -1 144)
				(proc255_0 431 18)
				(= seconds 3)
			)
			(11
				(proc255_0 431 19 67 -1 10)
				(proc255_0 431 20 67 -1 144)
				(= cycles (Random 2 8))
			)
			(12
				(proc0_3)
				(= temp0 1)
				(while (<= temp0 5)
					([local6 temp0]
						view: 430
						setCycle: Fwd
						setStep: 6 6
						setScript: (VeggieScript new:)
					)
					(++ temp0)
				)
				(= seconds 8)
			)
			(13
				(proc255_0 431 21 88 67 10 5 70 290)
				(= seconds 3)
			)
			(14
				(proc0_5)
				(= temp0 1)
				(while (<= temp0 5)
					(([local6 temp0] script?) changeState: 2)
					(++ temp0)
				)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 437
					register: (Format @local21 431 22)
					next: (Format @local61 431 23)
				)
			)
			(15
				(= gGNumber_2 431)
				(proc0_3)
				(proc0_6)
				(gGame changeScore: 43)
				(proc255_0 431 24 67 10 5 70 290)
				(aSpotlight setLoop: 5 setPri: 14 ignoreActors: init:)
				(aFloor setLoop: 6 setPri: 7 ignoreActors: init:)
				(gEgo setMotion: MoveTo local18 95 self)
				(= cycles 4)
			)
			(16
				(gTheMusic number: 432 loop: 1 play: self)
			)
			(17
				(gEgo setMotion: MoveTo local13 95 self)
			)
			(18
				(proc255_0 431 25 67 10 5 70 290 88)
				(theAActor1 setScript: (MoneyScript new:))
				(gEgo setMotion: MoveTo local15 95 self)
			)
			(19
				(theAActor2 setScript: (MoneyScript new:))
				(theAActor3 setScript: (MoneyScript new:))
				(gEgo setStep: 1 1 setMotion: MoveTo local18 95 self)
			)
			(20
				(proc0_5)
				(proc255_0 431 26 67 10 5 70 290 25 6 88)
				(theAActor4 setScript: (MoneyScript new:))
				(theAActor5 setScript: (MoneyScript new:))
				(= register 0)
				(self cue:)
			)
			(21
				(gEgo setMotion: MoveTo (Random local13 local18) 95 self)
				(/ global87 10)
				(if (>= 2 (++ register)) (-- state))
			)
			(22
				(gTheMusic loop: 1 play:)
				(global2 drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= temp0 1)
				(while (<= temp0 5)
					(([local0 temp0] script?) changeState: 2)
					(++ temp0)
				)
				(= cycles 20)
			)
			(23
				(gTheMusic fade:)
				(proc255_0 431 27)
				(proc255_0 431 28)
				(proc255_0 431 29)
				(proc255_0 431 30 67 10 144 70 290)
				(Load rsVIEW 708)
				(= global66 708)
				(= gGNumber_2 11)
				(= global104 6)
				(= global94 500)
				(Format ((Inv at: 6) name?) 431 31)
				((Inv at: 6) view: 24)
				(gEgo get: 6)
				(gGame setSpeed: global101)
				(global2 newRoom: 420)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
			(or (Said '/naked,dance') (Said 'naked,dance')) (self changeState: 15))
			((Said 'address') (proc255_0 431 0) (proc255_0 431 1))
			(
				(and
					(Said 'look>')
					(Said '[/area,backstage,couple,man,babe]')
				)
				(proc255_0 431 2)
				(proc255_0 431 3 67 -1 144)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if (== gGNumber_2 432)
					(pEvent claimed: 1)
					(if (== gCursorNumber 992)
						(switch gCursorNumber
							(992
								(gGame setCursor: 998 (HaveMouse))
								(pEvent claimed: 1)
							)
							(994
								(gGame setCursor: 998 (HaveMouse))
								(pEvent claimed: 1)
							)
							(997
								(gGame setCursor: 995 (HaveMouse))
								(pEvent claimed: 1)
							)
							(998
								(gGame setCursor: 997 (HaveMouse))
								(pEvent claimed: 1)
							)
							(995
								(gGame setCursor: 994 (HaveMouse))
								(pEvent claimed: 1)
							)
							(else  (pEvent claimed: 0))
						)
					)
				)
				(if
					(and
						(> (pEvent x?) 66)
						(< (pEvent x?) 211)
						(> (pEvent y?) 86)
						(< (pEvent y?) 117)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 431 2)
							(proc255_0 431 3 67 -1 144)
						)
						(995 (self changeState: 15))
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aActor1 of Act
	(properties)
)

(instance aActor2 of Act
	(properties)
)

(instance aActor3 of Act
	(properties)
)

(instance aActor4 of Act
	(properties)
)

(instance aActor5 of Act
	(properties)
)

(instance aSpotlight of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aFloor of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aCurtain of Prop
	(properties
		y 63
		x 15
		view 430
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 2 ignoreActors: stopUpd:)
	)
)

(instance VeggieScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles (Random 1 9)))
			(1
				(client
					setLoop: (Random 8 9)
					posn: (Random 8 290) (Random 144 157)
					setMotion: JumpTo (gEgo x?) (- (gEgo y?) (Random 0 33)) self
				)
				(-- state)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance MoneyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 430 setLoop: 7 setCycle: Fwd setStep: 7 7)
				(= cycles (Random 1 9))
			)
			(1
				(client
					posn: (Random 8 290) (Random 144 157)
					setMotion: JumpTo (gEgo x?) (- (gEgo y?) (Random 0 33)) self
				)
				(-- state)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)
