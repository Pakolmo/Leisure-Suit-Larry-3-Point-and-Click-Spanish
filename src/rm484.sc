;;; Sierra Script 1.0 - (do not remove this comment)
(script# 484)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm484 0
)

(local
	local0
	[local1 200]
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
		y 126
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

(instance rm484 of Rm
	(properties
		picture 480
		south 470
	)
	
	(method (init)
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(aWine init: setCel: (if (proc0_23 13) 1 else 0))
		(aDoor init: setCel: 255 stopUpd:)
		(if (proc0_23 14) (aPanties init:))
		(if (proc0_23 16) (aBra init:))
		(if (proc0_23 15) (aPantyhose init:))
		(aDress init:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(proc0_1)
		(= gGNumber_2 0)
		(if (== gGNumber 470)
			(gEgo posn: 159 188 loop: 3 init:)
		else
			(if (or (proc0_22 69) (== gGNumber 0))
				(proc0_20 69)
				(gTheWindow color: global105 back: global106)
				(TheMenuBar draw: state: 1)
				(SL enable:)
				(proc0_20 4)
				(proc0_20 5)
			)
			(= global66 800)
			(= global108 1)
			(= global82 (Format @global83 484 0))
			(= global98 4)
			(proc0_24 6 450)
			((Inv at: 6) view: 25)
			(Format ((Inv at: 6) name?) {47 d<lares en propinas})
			(proc0_24 18 450)
			(proc0_24 2 -1)
			(proc0_24 8 -1)
			(proc0_24 9 -1)
			(gEgo get: 12)
			((Inv at: 12) view: 30)
			(Format ((Inv at: 12) name?) 484 2)
			(gGame setSpeed: global101)
			(User canInput: 0 mapKeyToDir: 0)
			(Load rsVIEW 800)
			(gEgo
				view: 482
				posn: 160 59
				loop: 2
				baseSetter: SheetBase
				init:
			)
			(gTheMusic number: 492 loop: global72 play:)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gTheMusic fade:)
		(super newRoom: newRoomNumber)
		(gTheMusic fade:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0040)
			(if (and (not local0) (!= (gEgo view?) global66))
				(= local0 1)
				(proc255_0 484 3)
			)
		else
			(= local0 0)
		)
		(if (!= (gEgo view?) 800)
			(gEgo observeControl: 8192)
		else
			(gEgo ignoreControl: 8192)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_6)
				(gEgo get: 17 view: 800)
				(gGame changeScore: 10)
				(proc255_0 484 36)
				(aDress setCycle: End self)
				(++ state)
			)
			(2
				(proc0_6)
				(proc0_24 17)
				(gEgo view: 482)
				(gGame changeScore: -10)
				(proc255_0 484 37)
				(aDress setCycle: Beg self)
			)
			(3 (aDress stopUpd:))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'drain,(get<off)/dress')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (gEgo has: 17)) (proc0_12))
					(
					(and (gEgo has: 16) (gEgo has: 14) (gEgo has: 15)) (proc255_0 484 4))
					((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
					(else (self changeState: 2))
				)
			)
			(
				(Said
					'wear,drain,(on<backdrop),(alter<in),(backdrop<on),get>'
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9) (pEvent claimed: 1))
					((Said '/sheet')
						(if (== (gEgo view?) 482)
							(proc255_0 484 6)
						else
							(proc255_0 484 7)
						)
					)
					((Said '/beer,bottle')
						(cond 
							((not (proc0_23 13)) (proc0_11))
							((not (gEgo inRect: 126 126 196 141)) (proc0_10))
							(else
								(proc0_6)
								(aWine setCel: 0 stopUpd:)
								(gGame changeScore: 25)
								(gEgo get: 13)
							)
						)
					)
					((Said '/panties')
						(cond 
							((not (proc0_23 14)) (proc0_11))
							((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
							(else
								(proc0_6)
								(gEgo get: 14)
								(gGame changeScore: 20)
								(aPanties dispose:)
								(proc255_0 484 8)
							)
						)
					)
					((Said '/bra')
						(cond 
							((not (proc0_23 16)) (proc0_11))
							((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
							((gEgo has: 16) (proc255_0 484 9))
							(else
								(proc0_6)
								(gEgo get: 16)
								(gGame changeScore: 20)
								(aBra dispose:)
								(proc255_0 484 10)
							)
						)
					)
					((Said '/hose')
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							((not (proc0_23 15)) (proc0_11))
							((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
							(else
								(proc0_6)
								(gEgo get: 15)
								(gGame changeScore: 20)
								(aPantyhose dispose:)
								(proc255_0 484 11)
							)
						)
					)
					((Said '/dress')
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							((not (proc0_23 17)) (proc0_11))
							((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
							(else (self changeState: 1))
						)
					)
				)
			)
			((Said 'look<below') (proc255_0 484 12))
			((Said 'naked,naked') (proc255_0 484 13))
			((Said 'backdrop,decrease,drain,(get<off)/sheet') (proc255_0 484 14))
			((Said '/sandal') (proc255_0 484 15))
			((Said '/tray') (proc255_0 484 16))
			((Said 'gamble/keyboard') (proc255_0 484 17))
			((Said 'close/door') (proc255_0 484 18))
			((Said 'look>')
				(cond 
					((Said '/lotion,(buffet<dressing),cloth')
						(cond 
							((proc0_23 15) (proc255_0 484 19))
							((proc0_23 14) (proc255_0 484 20))
							((proc0_23 16) (proc255_0 484 21))
							(else (proc255_0 484 22))
						)
						(if (proc0_23 17) (proc255_0 484 23))
					)
					((Said '/buffet')
						(if (proc0_23 13)
							(proc255_0 484 24)
						else
							(proc255_0 484 25)
						)
						(if
						(or (proc0_23 15) (proc0_23 14) (proc0_23 16))
							(proc255_0 484 26)
						else
							(proc255_0 484 22)
						)
					)
					((Said '/tray')
						(if (proc0_23 13)
							(proc255_0 484 27)
						else
							(proc255_0 484 25)
						)
					)
					((and (proc0_23 13) (Said '/bottle')) (proc255_0 484 27))
					((Said '/bed') (proc255_0 484 28))
					((Said '/keyboard') (proc255_0 484 29))
					((Said '/binocular') (proc255_0 484 30))
					((Said '/burn') (proc255_0 484 31))
					((Said '/bush') (proc255_0 484 32))
					((Said '/balcony,look,cup') (proc255_0 484 33))
					((Said '[/area]') (proc255_0 484 34))
				)
			)
			((Said '/cloth') (proc255_0 484 35))
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 37)
						(< (pEvent x?) 47)
						(> (pEvent y?) 105)
						(< (pEvent y?) 137)
						(gCast contains: aDress)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(994
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (proc0_23 17)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								(else (self changeState: 1))
							)
						)
						(995
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (proc0_23 17)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								(else (self changeState: 1))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 138)
						(< (pEvent x?) 180)
						(> (pEvent y?) 180)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 158 192)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(proc0_26 aBra (pEvent x?) (pEvent y?))
						(gCast contains: aBra)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((not (proc0_23 16)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								((gEgo has: 16) (proc255_0 484 9))
								(else
									(proc0_6)
									(gEgo get: 16)
									(gGame changeScore: 20)
									(aBra dispose:)
									(proc255_0 484 10)
								)
							)
						)
						(994
							(cond 
								((not (proc0_23 16)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								((gEgo has: 16) (proc255_0 484 9))
								(else
									(proc0_6)
									(gEgo get: 16)
									(gGame changeScore: 20)
									(aBra dispose:)
									(proc255_0 484 10)
								)
							)
						)
						(998
							(if (proc0_23 16)
								(proc255_0 484 21)
							else
								(pEvent claimed: 0)
							)
						)
					)
				)
				(if
					(and
						(proc0_26 aPanties (pEvent x?) (pEvent y?))
						(gCast contains: aPanties)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((not (proc0_23 14)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								(else
									(proc0_6)
									(gEgo get: 14)
									(gGame changeScore: 20)
									(aPanties dispose:)
									(proc255_0 484 8)
								)
							)
						)
						(994
							(cond 
								((not (proc0_23 14)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								(else
									(proc0_6)
									(gEgo get: 14)
									(gGame changeScore: 20)
									(aPanties dispose:)
									(proc255_0 484 8)
								)
							)
						)
						(998
							(if (proc0_23 14)
								(proc255_0 484 20)
							else
								(pEvent claimed: 0)
							)
						)
					)
				)
				(if
					(and
						(proc0_26 aPantyhose (pEvent x?) (pEvent y?))
						(gCast contains: aPantyhose)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (proc0_23 15)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								(else
									(proc0_6)
									(gEgo get: 15)
									(gGame changeScore: 20)
									(aPantyhose dispose:)
									(proc255_0 484 11)
								)
							)
						)
						(994
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (proc0_23 15)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc255_0 484 5))
								(else
									(proc0_6)
									(gEgo get: 15)
									(gGame changeScore: 20)
									(aPantyhose dispose:)
									(proc255_0 484 11)
								)
							)
						)
						(998
							(if (proc0_23 15) (proc255_0 484 19))
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 153)
						(< (pEvent x?) 179)
						(> (pEvent y?) 109)
						(< (pEvent y?) 136)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((not (proc0_23 13)) (proc0_11))
								((not (gEgo inRect: 126 126 196 141)) (proc0_10))
								(else
									(proc0_6)
									(aWine setCel: 0 stopUpd:)
									(gGame changeScore: 25)
									(gEgo get: 13)
								)
							)
						)
						(998
							(if (proc0_23 13)
								(proc255_0 484 27)
							else
								(proc255_0 484 25)
							)
						)
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
						(998 (proc255_0 484 28))
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
						(998 (proc255_0 484 29))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(proc0_26 aWine (pEvent x?) (pEvent y?))
						(gCast contains: aWine)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((not (proc0_23 13)) (proc0_11))
								((not (gEgo inRect: 126 126 196 141)) (proc0_10))
								(else
									(proc0_6)
									(aWine setCel: 0 stopUpd:)
									(gGame changeScore: 25)
									(gEgo get: 13)
								)
							)
						)
						(998
							(if (proc0_23 13)
								(proc255_0 484 27)
							else
								(proc255_0 484 25)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance SheetBase of Code
	(properties)
	
	(method (doit)
		(gEgo brBottom: (+ (gEgo y?) 1))
		(gEgo brTop: (- (gEgo brBottom?) 2))
		(gEgo brLeft: (- (gEgo x?) 9))
		(gEgo brRight: (+ (gEgo x?) 9))
	)
)
