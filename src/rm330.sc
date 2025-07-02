;;; Sierra Script 1.0 - (do not remove this comment)
(script# 330)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Jump)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm330 0
)
(synonyms
	(man man dale)
)

(local
	local0
	local1
	local2
	theADrinker1
	local4
	local5
	local6
)
(instance rm330 of Rm
	(properties
		picture 330
		east 230
	)
	
	(method (init)
		(proc0_19 36)
		(= gGNumber_2 17)
		(Load rsVIEW 330)
		(Load rsVIEW 333)
		(Load rsVIEW 332)
		(Load rsVIEW 337)
		(Load rsVIEW 336)
		(Load rsVIEW 14)
		(Load rsSOUND 330)
		(Load rsSOUND 331)
		(Load rsSOUND 332)
		(Load rsSOUND 10)
		(Load rsSCRIPT 991)
		(Load rsSCRIPT 969)
		(super init:)
		(gAddToPics add: atpPchair add: atpDchair doit:)
		(aDale init:)
		(aClothes init:)
		(aDrinker1 init:)
		(aDrinker2 init:)
		(aDrinker3 init:)
		(aDrinker4 init:)
		(aCurtain init:)
		(aPanties init:)
		(self setScript: RoomScript)
		(User canInput: 0 canControl: 1 mapKeyToDir: 0)
		(if (== gGNumber 335)
			(proc0_3)
			(gEgo
				view: 332
				setLoop: 4
				setCel: 255
				posn: 281 140
				illegalBits: 0
				init:
			)
			(RoomScript changeState: 3)
			(aDale
				view: 337
				setLoop: 4
				setCel: 255
				posn: 283 121
				cycleSpeed: 1
			)
			(DaleScript changeState: 24)
		else
			(proc0_1)
			(gEgo
				view: 332
				loop: 1
				posn: 317 129
				baseSetter: squareBase
				init:
			)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 281 140 self
				)
			)
			(2
				(gEgo setLoop: 4 setPri: 3 setCel: 0 setCycle: End self)
			)
			(3
				(User canInput: 1)
				(= gGNumber_2 1004)
				(if local1
					(= cycles 0)
					(= seconds 3)
				else
					(= local1 1)
					(DaleScript changeState: 1)
				)
			)
			(4
				(if (== local2 2)
					(gEgo loop: 5 setCycle: Fwd)
					(= cycles (Random 11 33))
				else
					(self changeState: 6)
				)
			)
			(5
				(gEgo setLoop: 4 setCel: 255)
				(= cycles (Random 11 33))
			)
			(6
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(7 (= cycles (Random 33 66)))
			(8
				(gEgo setCycle: Beg self)
				(= state 3)
			)
			(9
				(proc0_3)
				(= cycles (= seconds 0))
				(gEgo view: 332 setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(10
				(gEgo
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 282 132 self
				)
			)
			(11
				(= gGNumber_2 1004)
				(proc0_1 1 332)
				(gEgo baseSetter: squareBase)
			)
			(12
				(proc0_6)
				(proc255_0 330 38)
				(= cycles (= seconds 0))
				(proc0_3)
				(gEgo
					view: 336
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(13
				(gEgo setLoop: 1 cel: 0 setCycle: Fwd)
				(= cycles 15)
			)
			(14
				(gEgo cycleSpeed: 0)
				(= cycles 15)
			)
			(15 (= cycles 10))
			(16
				(proc255_0 330 39 82 14 0 0 67 -1 10)
				(gEgo cycleSpeed: 1 setLoop: 2 cel: 0 setCycle: End)
				(proc0_24 14)
				(aPanties
					posn: (gEgo x?) (gEgo y?)
					setMotion: JumpTo 42 96 self
				)
			)
			(17
				(proc255_0 330 40)
				(= cycles (= seconds 0))
				(aPanties stopUpd:)
				(gGame changeScore: 100)
				(User canInput: 1)
				(gEgo view: 332)
				(if (== gGNumber_2 1004)
					(self changeState: 2)
				else
					(proc0_1 1 332)
					(gEgo baseSetter: squareBase)
				)
			)
			(18
				(proc0_6)
				(proc0_3)
				(= gGNumber_2 1004)
				(if (not (proc0_22 56))
					(proc255_0 330 41)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(19
				(if (not (proc0_22 56))
					(proc0_19 56)
					(gGame changeScore: 1)
					(proc255_0 330 42)
				)
				(global2 newRoom: 335)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if local2
			(cond 
				((Said 'caress,get,grab,caress/man') (proc255_0 330 0))
				((Said 'applaud')
					(proc255_0 330 1)
					(if (== gGNumber_2 1004) (self changeState: 4))
				)
				((Said '(get<off),drain/panties') (proc255_0 330 2))
				((Said 'give,throw/panties>')
					(cond 
						((not (gEgo has: 14)) (proc0_12))
						((Said '/[/!*]') (proc255_0 330 3))
						((not (Said '//backstage,man')) (proc255_0 330 4))
						((!= local2 2) (proc255_0 330 5))
						(else (self changeState: 12))
					)
					(pEvent claimed: 1)
				)
				((Said 'look/man,eye')
					(cond 
						((== local2 0) (proc255_0 330 6))
						((< local2 6) (proc255_0 330 7) (proc255_0 330 8 67 -1 144))
						((> local2 6) (proc255_0 330 9))
						((!= gGNumber_2 1004) (proc255_0 330 10))
						(else (self changeState: 18))
					)
				)
				((Said 'address/man')
					(switch local2
						(2 (proc255_0 330 11))
						(3 (proc255_0 330 12))
						(4 (proc255_0 330 13))
						(5
							(proc255_0 330 14)
							(= local5 1)
						)
						(1 (proc255_0 330 12))
						(6 (proc255_0 330 15))
						(else  (proc255_0 330 16))
					)
				)
				((Said 'address') (proc255_0 330 17))
				(
					(and
						(== local2 6)
						(or
							(Said 'eat,eat,eat/man')
							(Said 'caress,caress,caress/man')
						)
					)
					(proc255_0 330 18)
				)
			)
		)
		(cond 
			((and local0 (Said 'get,(up<pick)/cloth')) (proc255_0 330 19))
			((Said 'get,buy/drink,cup') (proc255_0 330 20))
			(
				(or
					(Said 'go,climb,(get<on)/backstage,buffet,barstool')
					(Said 'whistle,holler')
				)
				(proc255_0 330 21)
			)
			((Said 'lie')
				(cond 
					((& (gEgo onControl:) $0004) (proc255_0 330 22))
					((not (& (gEgo onControl:) $0002)) (proc0_10))
					((== gGNumber_2 1004) (proc0_8))
					((!= gGNumber_2 17) (proc0_9))
					(else (proc0_6) (self changeState: 1))
				)
			)
			(
				(or
					(Said 'nightstand,(get<off),(get<up),(nightstand<up)')
					(Said 'exit/barstool')
				)
				(cond 
					((== gGNumber_2 17) (proc0_8))
					((!= gGNumber_2 1004) (proc0_9))
					((== local2 6) (proc255_0 330 23))
					(else (self changeState: 9))
				)
			)
			((Said 'throw/buck,tip,buck') (proc255_0 330 24))
			((Said 'look,caress<below/buffet,barstool') (proc255_0 330 25))
			((Said 'look>')
				(cond 
					((and local0 (Said '/cloth,buffet')) (proc255_0 330 26))
					((Said '/backstage') (proc255_0 330 27))
					((Said '/barstool')
						(proc255_0 330 28)
						(if (== gGNumber_2 1004) (proc255_0 330 29))
						(if (== local2 6)
							(proc255_0 330 30)
							(proc255_0 330 31 67 -1 144)
						)
					)
					((Said '/burn') (proc255_0 330 32))
					((Said '/curtain')
						(if (aCurtain cel?)
							(proc255_0 330 33)
						else
							(proc255_0 330 34)
						)
					)
					((Said '/buffet,babe,man,cup,drink,couple') (proc255_0 330 35))
					((Said '[/area]') (proc255_0 330 36) (proc255_0 330 37 67 -1 144))
				)
			)
			((== (pEvent type?) evMOUSEBUTTON)
				(if (& (pEvent modifiers?) emSHIFT)
					(switch gCursorNumber
						(gGCursorNumber
							(gGame setCursor: 999 (HaveMouse))
							(pEvent claimed: 1)
						)
						(991
							(gGame setCursor: 998 (HaveMouse))
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
								)
								(gGame setCursor: 999 (HaveMouse))
							else
								(gGame setCursor: gGCursorNumber (HaveMouse))
								(= gCursorNumber gGCursorNumber)
							)
							(pEvent claimed: 1)
						)
					)
				else
					(if
						(and
							(> (pEvent x?) 119)
							(< (pEvent x?) 270)
							(> (pEvent y?) 21)
							(< (pEvent y?) 170)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(proc255_0 330 36)
								(proc255_0 330 37 67 -1 144)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 311)
							(< (pEvent x?) 319)
							(> (pEvent y?) 105)
							(< (pEvent y?) 177)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(999
								(gEgo setMotion: MoveTo 321 145)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(or
							(proc0_26 aDale (pEvent x?) (pEvent y?))
							(and
								(> (pEvent x?) 37)
								(< (pEvent x?) 106)
								(> (pEvent y?) 50)
								(< (pEvent y?) 121)
							)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(14
								(cond 
									((not (gEgo has: 14)) (proc0_12))
									((!= local2 2) (proc255_0 330 5))
									(else
										(= gGCursorNumber 900)
										(gGame setCursor: 998 (HaveMouse))
										(self changeState: 12)
									)
								)
								(pEvent claimed: 1)
							)
							(998
								(cond 
									((== local2 0) (proc255_0 330 6))
									((< local2 6) (proc255_0 330 7) (proc255_0 330 8 67 -1 144))
									((> local2 6) (proc255_0 330 9))
									((!= gGNumber_2 1004) (proc255_0 330 10))
									(else (RoomScript changeState: 18) (= gGNumber_2 1004))
								)
							)
							(996
								(switch local2
									(2 (proc255_0 330 11))
									(3 (proc255_0 330 12))
									(4 (proc255_0 330 13))
									(5
										(proc255_0 330 14)
										(= local5 1)
									)
									(1 (proc255_0 330 12))
									(6 (proc255_0 330 15))
									(else  (proc255_0 330 16))
								)
							)
							(994
								(cond 
									((not (gEgo has: 14)) (proc0_12))
									((!= local2 2) (proc255_0 330 5))
									(else
										(= gGCursorNumber 900)
										(gGame setCursor: 998 (HaveMouse))
										(self changeState: 12)
									)
								)
								(pEvent claimed: 1)
							)
						)
					)
					(if
						(or
							(proc0_26 atpPchair (pEvent x?) (pEvent y?))
							(proc0_26 atpDchair (pEvent x?) (pEvent y?))
						)
						(proc0_23 14)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(cond 
									((== local2 0) (proc255_0 330 6))
									((< local2 6) (proc255_0 330 7) (proc255_0 330 8 67 -1 144))
									((> local2 6) (proc255_0 330 9))
									((!= gGNumber_2 1004) (proc255_0 330 10))
									(else (DaleScript changeState: 18))
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 282)
							(< (pEvent x?) 293)
							(> (pEvent y?) 137)
							(< (pEvent y?) 153)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(cond 
									((== local2 0) (proc255_0 330 6))
									((< local2 6) (proc255_0 330 7) (proc255_0 330 8 67 -1 144))
									((> local2 6) (proc255_0 330 9))
									((!= gGNumber_2 1004) (proc255_0 330 10))
									(else (DaleScript changeState: 18))
								)
							)
							(995
								(cond 
									((& (gEgo onControl:) $0004))
									((not (& (gEgo onControl:) $0002)) (proc0_10))
									((== gGNumber_2 1004) (RoomScript changeState: 9) (= gGNumber_2 0))
									((!= gGNumber_2 17) (proc0_9))
									(else
										(proc0_6)
										(RoomScript changeState: 1)
										(= gGNumber_2 1004)
									)
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(or
							(proc0_26 aDrinker1 (pEvent x?) (pEvent y?))
							(proc0_26 aDrinker2 (pEvent x?) (pEvent y?))
							(proc0_26 aDrinker3 (pEvent x?) (pEvent y?))
							(proc0_26 aDrinker4 (pEvent x?) (pEvent y?))
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(996 (proc255_0 330 17))
							(else  (pEvent claimed: 0))
						)
					)
					(if (proc0_26 aClothes (pEvent x?) (pEvent y?))
						(pEvent claimed: 1)
						(switch gCursorNumber
							(995 (proc255_0 330 19))
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(== (pEvent type?) evMOUSEBUTTON)
							(== gGNumber_2 0)
						)
						(pEvent claimed: 1)
						(cond 
							((== gGNumber_2 17) (proc0_8))
							((!= gGNumber_2 1004) (RoomScript changeState: 1) (= gGNumber_2 1004))
							((== local2 6)
								(proc255_0 330 23)
								(RoomScript changeState: 9)
								(= gGNumber_2 1004)
							)
							(else (RoomScript changeState: 9) (= gGNumber_2 0))
						)
					)
					(if
						(and
							(== (pEvent type?) evMOUSEBUTTON)
							(== gGNumber_2 1004)
							(== gCursorNumber 992)
						)
						(pEvent claimed: 1)
						(cond 
							((== gGNumber_2 17) (proc0_8))
							((!= gGNumber_2 1004)
								(proc0_9)
								(RoomScript changeState: 9)
								(= gGNumber_2 1004)
							)
							((== local2 6)
								(proc255_0 330 23)
								(RoomScript changeState: 9)
								(= gGNumber_2 1004)
							)
							(else (RoomScript changeState: 9) (= gGNumber_2 0))
						)
					)
				)
			)
		)
	)
)

(instance aDale of Act
	(properties
		y 86
		x -86
		view 333
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd setScript: DaleScript)
	)
)

(instance DaleScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1 (= seconds (Random 2 5)))
			(2
				(gTheMusic number: 10 loop: -1 play:)
				(proc255_0 330 43)
				(proc255_0 330 44 67 -1 144)
				(aCurtain setCycle: End self)
			)
			(3
				(= global101 (gGame setSpeed: 6))
				(aCurtain stopUpd:)
				(gTheMusic number: 330 loop: -1 play:)
				(aDale setLoop: 0 setMotion: MoveTo 89 86 self)
				(= local2 1)
			)
			(4
				(aCurtain setCycle: Beg self)
				(aDale setLoop: 1 setCel: 0)
				(= local2 2)
			)
			(5
				(aCurtain stopUpd:)
				(aDale cycleSpeed: 1 setCycle: End self)
			)
			(6
				(aDale setLoop: 2 setCel: 0 setCycle: CT 6 1 self)
			)
			(7
				(aDale setCycle: End)
				(aClothes posn: 105 83 setMotion: JumpTo 248 133 self)
			)
			(8
				(aClothes stopUpd:)
				(= local0 1)
				(= cycles 20)
			)
			(9
				(aDale
					cycleSpeed: 1
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
				(= local4 0)
			)
			(10
				(aDale setCycle: Fwd setLoop: 4)
				(= cycles 22)
			)
			(11
				(if (> 3 (++ local4)) (= state 9))
				(aDale
					setLoop: 5
					setMotion: MoveTo (Random 63 68) (Random 110 110)
				)
				(= cycles (Random 11 22))
			)
			(12
				(aDale setMotion: MoveTo 89 86 self)
			)
			(13
				(aDale setLoop: 6 cel: 0 setCycle: End)
				(gTheMusic number: 331 loop: 1 play:)
				(= cycles 33)
			)
			(14
				(proc255_0 330 45 67 -1 10)
				(proc255_0 330 46 67 -1 10)
				(= cycles (Random 11 44))
			)
			(15
				(aCurtain setCycle: End)
				(aDale setCycle: CT 8 -1)
				(gTheMusic number: 330 play:)
				(= cycles 22)
			)
			(16
				(aCurtain stopUpd:)
				(aDale
					cycleSpeed: 0
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 42 86 self
				)
				(= local2 3)
			)
			(17
				(if (proc0_23 14 330)
					(aPanties hide:)
					((Inv at: 14) owner: 335)
				)
				(aDale setMotion: MoveTo -40 86 self)
			)
			(18
				(aDale stopUpd:)
				(aCurtain setCycle: Beg)
				(gTheMusic fade:)
				(= local2 4)
				(= seconds 5)
			)
			(19
				(gGame setSpeed: global101)
				(aCurtain dispose:)
				(gTheMusic stop: number: 332 loop: global72 play:)
				(= seconds (Random 7 15))
			)
			(20
				(= local2 5)
				(aDale
					view: 337
					setLoop: -1
					setCycle: Walk
					ignoreActors: 0
					illegalBits: 0
					posn: 245 -10
					baseSetter: squareBase
					setMotion: MoveTo 316 129 self
				)
				(= cycles 20)
			)
			(21 (proc255_0 330 47))
			(22
				(if (or local5 (proc0_23 14 335))
					(= local2 6)
					(aDale
						ignoreActors:
						illegalBits: 0
						setMotion: MoveTo 283 121 self
					)
					(if (proc0_23 14 335)
						(proc255_0 330 48)
					else
						(proc255_0 330 49)
					)
				else
					(self changeState: 26)
				)
			)
			(23
				(aDale
					posn: 283 121
					cycleSpeed: 1
					setLoop: 4
					setCel: 0
					setCycle: End self
				)
			)
			(24 (= seconds 11))
			(25
				(if (!= gGNumber_2 1004)
					(= seconds 15)
					(-- state)
				else
					(proc255_0 330 50)
					(= local2 5)
					(aDale setCycle: Beg self)
				)
			)
			(26
				(aDale
					cycleSpeed: 0
					setStep: 3 2
					setCycle: Walk
					ignoreActors: 1
					illegalBits: 0
					setLoop: -1
					baseSetter: squareBase
					setMotion: MoveTo 333 143 self
				)
			)
			(27
				(= local2 7)
				(aDale dispose:)
			)
		)
	)
)

(instance aDrinker1 of Prop
	(properties
		y 8
		x 221
		view 330
		loop 2
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aDrinker2 of Prop
	(properties
		y 44
		x 239
		view 330
		loop 3
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aDrinker3 of Prop
	(properties
		y 77
		x 225
		view 330
		loop 4
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aDrinker4 of Prop
	(properties
		y 166
		x 264
		view 330
		loop 5
	)
	
	(method (init)
		(super init:)
		(self setScript: drinkerScript ignoreActors: stopUpd:)
	)
)

(instance drinkerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 5)))
			(1
				(switch (Random 1 4)
					(1 (= theADrinker1 aDrinker1))
					(2 (= theADrinker1 aDrinker2))
					(3 (= theADrinker1 aDrinker3))
					(4 (= theADrinker1 aDrinker4))
				)
				(theADrinker1 setCycle: End self)
			)
			(2 (= cycles (Random 15 29)))
			(3
				(theADrinker1 setCycle: Beg self)
			)
			(4 (self changeState: 0))
		)
	)
)

(instance atpPchair of PV
	(properties
		y 140
		x 281
		view 330
		loop 1
		priority 1
		signal $4000
	)
)

(instance atpDchair of PV
	(properties
		y 121
		x 281
		view 330
		loop 1
		cel 1
		priority 1
		signal $4000
	)
)

(instance aCurtain of Prop
	(properties
		y 88
		view 330
		cycleSpeed 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 3 ignoreActors:)
	)
)

(instance aPanties of Act
	(properties
		y 1142
		x 283
		view 336
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 3
			setPri: 15
			setCycle: Fwd
			setStep: 10 6
			ignoreActors:
		)
	)
)

(instance aClothes of Act
	(properties
		y 1083
		x 105
		view 333
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 7
			setPri: 15
			setCycle: Fwd
			setStep: 5 5
			ignoreActors:
		)
	)
)

(instance squareBase of Code
	(properties)
	
	(method (doit param1)
		(param1 brBottom: (+ (param1 y?) 5))
		(param1 brTop: (- (param1 brBottom?) 9))
		(param1 brLeft: (- (param1 x?) 8))
		(param1 brRight: (+ (param1 x?) 8))
	)
)
