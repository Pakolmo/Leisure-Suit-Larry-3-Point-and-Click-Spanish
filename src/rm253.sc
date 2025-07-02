;;; Sierra Script 1.0 - (do not remove this comment)
(script# 253)
(include sci.sh)
(use Main)
(use AutoDoor)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm253 0
)
(synonyms
	(barrel can barrel)
	(basin handle faucet fountain)
)

(local
	local0
	local1
)
(instance rm253 of Rm
	(properties
		picture 253
		west 250
	)
	
	(method (init)
		(Load rsVIEW 254)
		(if global108
			(= local0 45)
			(= local1 139)
		else
			(= local0 43)
			(= local1 137)
		)
		(if
		(and (gEgo has: 4) (== ((Inv at: 4) view?) 23))
			(Load rsVIEW 707)
			(Load rsVIEW 701)
			(Load rsVIEW 23)
		)
		(if (gEgo has: 13) (Load rsVIEW 13))
		(if (not (proc0_22 30))
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(if
			(or
				(proc0_22 15)
				(and
					(not (Random 0 4))
					(> global87 16)
					(not global108)
					(not (proc0_22 64))
					(proc0_22 30)
				)
			)
			(aJodi init:)
			(aBill init:)
			(alsHead init:)
			(alsFeet init:)
		)
		(super init:)
		(self setScript: RoomScript)
		(if (proc0_23 5) (aSoap init:))
		(aDoor setPri: 10 ignoreActors: init:)
		(gEgo posn: 1 171)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			(
				(and
					(& (gEgo onControl:) $0002)
					(or (< (gEgo heading?) 90) (> (gEgo heading?) 269))
				)
				(aDoor doorCtrl: 2 loop: 0)
			)
			(
				(and
					(& (gEgo onControl:) $0010)
					(> (gEgo heading?) 89)
					(< (gEgo heading?) 271)
				)
				(aDoor doorCtrl: 16 loop: 1)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(proc0_6)
				(gEgo illegalBits: 0 setMotion: MoveTo local0 local1 self)
			)
			(2
				(gEgo view: 254 loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(aSoap dispose:)
				(gEgo get: 5 loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(proc0_1 0)
				(gGame changeScore: 12)
				(proc255_0 253 31)
			)
			(5
				(proc0_3)
				(proc0_6)
				(gEgo illegalBits: 0 setMotion: MoveTo local0 local1 self)
			)
			(6
				(gTheSoundFX number: 253 loop: 11 play:)
				(gEgo
					view: (+ 254 global108)
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(7
				(gEgo loop: 1 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(gEgo loop: 0 setCel: 255 setCycle: Beg self)
			)
			(9
				(gTheSoundFX stop:)
				(if (not (proc0_22 7))
					(proc0_19 7)
					(gGame changeScore: 2)
				)
				(proc255_0 253 32 67 -1 10)
				(proc0_1 0)
			)
			(10
				(proc0_3)
				(proc0_6)
				(gEgo illegalBits: 0 setMotion: MoveTo local0 local1 self)
			)
			(11
				(gTheSoundFX number: 253 loop: 1 play:)
				(gEgo
					view: (+ 254 global108)
					loop: 2
					cel: 0
					setCycle: End self
				)
				(proc255_0 253 33 82 13 0 0)
			)
			(12
				(gEgo loop: 3 setCycle: Fwd)
				(= seconds 5)
			)
			(13
				(gEgo loop: 2 setCel: 255 setCycle: Beg self)
			)
			(14
				(gTheSoundFX stop:)
				((Inv at: 13) view: 29)
				(Format ((Inv at: 13) name?) 253 34)
				(if (not (proc0_22 42))
					(proc0_19 42)
					(gGame changeScore: 37)
				)
				(proc0_1 0)
			)
			(15
				(proc0_3)
				(proc0_6)
				(if (not (proc0_22 59))
					(proc0_19 59)
					(gGame changeScore: 10)
				)
				(gEgo
					illegalBits: 0
					cycleSpeed: 1
					view: 701
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(16
				(= global66 707)
				(= gGNumber_2 10)
				(proc0_1 3)
				(proc255_0 253 35 82 23 0 0)
			)
			(17
				(proc0_6)
				(proc0_3)
				(gEgo
					illegalBits: 0
					cycleSpeed: 1
					view: 701
					loop: 2
					setCel: 255
					setCycle: Beg self
				)
			)
			(18
				(= global66 700)
				(= gGNumber_2 0)
				(proc0_1 3)
				(if (gEgo has: 6)
					(proc0_24 4 -1)
					(proc255_0 253 36)
					(= gGCursorNumber 900)
					(gGame setCursor: 998 (HaveMouse))
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'drink')
					(Said 'drag/basin,water')
					(Said 'get/drink/water')
					(Said 'get/drink')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0080)) (proc255_0 253 0))
					(else (self changeState: 5))
				)
			)
			((Said 'leak')
				(if (not (& (gEgo onControl:) $0010))
					(proc255_0 253 1)
				else
					(proc255_0 253 2)
				)
			)
			(
				(or
					(Said 'fill/bottle')
					(Said 'backdrop/water/bottle')
					(Said 'get/water')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0080)) (proc255_0 253 0))
					((not (gEgo has: 13)) (proc255_0 253 3))
					((!= ((Inv at: 13) view?) 28) (proc255_0 253 4))
					(else (self changeState: 10))
				)
			)
			((Said 'get/soap')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (proc0_23 5)) (proc0_11))
					((not (& (gEgo onControl:) $0080)) (proc0_10))
					(else (self changeState: 1))
				)
			)
			(
				(or
					(Said 'wear,(alter<in),(backdrop<on)/blade,skirt')
					(Said '(alter<from,out),(get<off),drain/cloth,cloth')
				)
				(cond 
					((& (gEgo onControl:) $0040) (proc255_0 253 5))
					((not (& (gEgo onControl:) $0010)) (proc255_0 253 1))
					((not (gEgo has: 4)) (proc255_0 253 6))
					((!= ((Inv at: 4) view?) 23) (proc255_0 253 7))
					((and (< global88 3) (aDoor cel?)) (proc255_0 253 8))
					((== gGNumber_2 10) (self changeState: 17))
					(else (self changeState: 15))
				)
			)
			(
				(or
					(Said 'wear,(alter<in),(backdrop<on)/cloth,cloth')
					(Said '(alter<from,out),(get<off),drain/blade,skirt')
				)
				(cond 
					((== gGNumber_2 0) (proc255_0 253 6))
					((& (gEgo onControl:) $0040) (proc255_0 253 5))
					((not (& (gEgo onControl:) $0010)) (proc255_0 253 1))
					((!= gGNumber_2 10) (proc255_0 253 9))
					((and (< global88 3) (aDoor cel?)) (proc255_0 253 8))
					(else (self changeState: 17))
				)
			)
			((Said 'clean/eye,body,i,bracelet')
				(if (or (proc0_22 8) (proc0_22 10))
					(proc255_0 253 10)
				else
					(proc255_0 253 11)
				)
			)
			((Said 'look>')
				(cond 
					((Said '/bathroom,building') (proc255_0 253 12))
					((Said '/basin')
						(proc255_4
							253
							13
							(if (proc0_23 5)
								{ Sobre el lavabo cuelga una pastilla de jab>n, suspendida de una cuerda atada a un clavo.}
							else
								{}
							)
						)
					)
					((and (proc0_23 5) (Said '/soap,hemp')) (proc255_0 253 14))
					((and (not (gEgo has: 13)) (Said '/water')) (proc255_0 253 15))
					((Said '/wall,clovis')
						(if (& (gEgo onControl:) $0010)
							(proc255_0 253 16)
						else
							(proc255_0 253 17)
						)
					)
					((Said '/clovis') (proc255_0 253 18))
					((Said '/nail,board,hemp') (proc255_0 253 19))
					((Said '/barstool,hole')
						(if (& (gEgo onControl:) $0010)
							(proc255_0 253 20)
						else
							(proc0_10)
						)
					)
					((Said '/barrel')
						(if (& (gEgo onControl:) $0100)
							(proc255_0 253 21)
							(proc255_0 253 22)
						else
							(proc0_10)
						)
					)
					((Said '/backstage,casino') (proc255_0 253 23))
					((Said '/door')
						(cond 
							((& (gEgo onControl:) $0010) (proc255_0 253 24))
							((& (gEgo onControl:) $0002) (proc255_0 253 25))
							((& (gEgo onControl:) $0004) (proc255_0 253 26))
							((& (gEgo onControl:) $0008) (proc255_0 253 27))
							(else (proc0_10))
						)
					)
					((Said '[/area]') (proc255_0 253 28))
				)
			)
			((Said '/door') (proc255_0 253 29))
			((Said '/barrel') (proc255_0 253 30))
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if (proc0_26 aDoor (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((& (gEgo onControl:) $0010) (proc255_0 253 24))
								((& (gEgo onControl:) $0002) (proc255_0 253 25))
								((& (gEgo onControl:) $0004) (proc255_0 253 26))
								((& (gEgo onControl:) $0008) (proc255_0 253 27))
								(else (proc0_10))
							)
						)
						(994
							(cond 
								((& (gEgo onControl:) $0040) (proc255_0 253 5))
								((not (& (gEgo onControl:) $0010)) (proc255_0 253 1))
								((not (gEgo has: 4)) (proc255_0 253 6))
								((!= ((Inv at: 4) view?) 23) (proc255_0 253 7))
								((and (< global88 3) (aDoor cel?)) (proc255_0 253 8))
								((== gGNumber_2 10) (self changeState: 17))
								(else (self changeState: 15))
							)
						)
						(4
							(cond 
								((& (gEgo onControl:) $0040) (proc255_0 253 5))
								((not (& (gEgo onControl:) $0010)) (proc255_0 253 1))
								((not (gEgo has: 4)) (proc255_0 253 6))
								((!= ((Inv at: 4) view?) 23) (proc255_0 253 7))
								((and (< global88 3) (aDoor cel?)) (proc255_0 253 8))
								((== gGNumber_2 10) (self changeState: 17))
								(else (self changeState: 15))
							)
						)
						(23
							(cond 
								((& (gEgo onControl:) $0040) (proc255_0 253 5))
								((not (& (gEgo onControl:) $0010)) (proc255_0 253 1))
								((not (gEgo has: 4)) (proc255_0 253 6))
								((!= ((Inv at: 4) view?) 23) (proc255_0 253 7))
								((and (< global88 3) (aDoor cel?)) (proc255_0 253 8))
								((== gGNumber_2 10) (self changeState: 17))
								(else (self changeState: 15))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 gEgo (pEvent x?) (pEvent y?))
					(if (== gCursorNumber 994)
						(pEvent claimed: 1)
						(cond 
							((& (gEgo onControl:) $0040) (proc255_0 253 5))
							((not (& (gEgo onControl:) $0010)) (proc255_0 253 1))
							((not (gEgo has: 4)) (proc255_0 253 6))
							((!= ((Inv at: 4) view?) 23) (proc255_0 253 7))
							((and (< global88 3) (aDoor cel?)) (proc255_0 253 8))
							((== gGNumber_2 10) (self changeState: 17))
							(else (self changeState: 15))
						)
					)
					(if (== gCursorNumber 23)
						(pEvent claimed: 1)
						(cond 
							((& (gEgo onControl:) $0040) (proc255_0 253 5))
							((not (& (gEgo onControl:) $0010)) (proc255_0 253 1))
							((not (gEgo has: 4)) (proc255_0 253 6))
							((!= ((Inv at: 4) view?) 23) (proc255_0 253 7))
							((and (< global88 3) (aDoor cel?)) (proc255_0 253 8))
							((== gGNumber_2 10) (self changeState: 17))
							(else (self changeState: 15))
						)
					)
				else
					(pEvent claimed: 0)
				)
				(if (proc0_26 aJodi (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((< (aJodi y?) 0) (proc255_0 253 45))
								((and (> state 3) (< state 6)) (proc255_0 253 46))
								(else (proc255_0 253 47))
							)
						)
						(996
							(proc255_0 253 44 67 -1 144)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(or
						(proc0_26 alsHead (pEvent x?) (pEvent y?))
						(proc0_26 alsFeet (pEvent x?) (pEvent y?))
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 253 39))
						(996 (proc255_0 253 38))
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aBill (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 253 40))
						(996 (proc255_0 253 37))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 1)
						(< (pEvent x?) 10)
						(> (pEvent y?) 148)
						(< (pEvent y?) 179)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo -4 169)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 47)
						(< (pEvent x?) 319)
						(> (pEvent y?) 143)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 253 28))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 236)
						(< (pEvent x?) 251)
						(> (pEvent y?) 110)
						(< (pEvent y?) 128)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(if
								(if (& (gEgo onControl:) $0100)
									(proc255_0 253 21)
									(proc255_0 253 22)
								)
							else
								(proc0_10)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 48)
						(< (pEvent x?) 64)
						(> (pEvent y?) 104)
						(< (pEvent y?) 134)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (proc0_23 5)) (proc0_11))
								((not (& (gEgo onControl:) $0080)) (proc0_10))
								(else (self changeState: 1))
							)
						)
						(996
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (& (gEgo onControl:) $0080)) (proc255_0 253 0))
								(else (self changeState: 5))
							)
						)
						(998
							(if (and (proc0_23 5) (proc255_0 253 14)) 1)
						)
						(28
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (& (gEgo onControl:) $0080)) (proc255_0 253 0))
								((!= ((Inv at: 13) view?) 28) (proc255_0 253 4))
								(else (RoomScript changeState: 10))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aDoor of AutoDoor
	(properties
		y 126
		x 93
		view 253
		roomCtrl 0
	)
)

(instance aSoap of View
	(properties
		y 111
		x 64
		view 253
		loop 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 ignoreActors: stopUpd:)
	)
)

(instance BillScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBill setCel: 0)
				(= seconds (Random 2 9))
			)
			(1
				(aBill setLoop: 5 setCycle: Fwd)
				(= state -1)
				(= seconds (Random 2 5))
			)
			(2
				(aBill setLoop: 6 cel: 0 setCycle: End self)
				(= seconds 0)
			)
			(3
				(proc255_0 253 42)
				(proc255_0 253 43)
				(= seconds 3)
			)
			(4
				(aBill setCycle: Beg self)
				(= state -1)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((super handleEvent: pEvent))
			((Said 'address/bill,man') (proc255_0 253 37))
			((Said 'address/al') (proc255_0 253 38))
			((Said 'look/al') (proc255_0 253 39))
			((Said 'look/bill') (proc255_0 253 40))
			((Said 'look/man') (proc255_0 253 41))
		)
	)
)

(instance aJodi of Act
	(properties
		y 143
		x -30
		view 256
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setCycle: Walk setScript: JodiScript)
	)
)

(instance JodiScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 5 10)))
			(1
				(aJodi setMotion: MoveTo 184 143 self)
			)
			(2
				(aJodi setMotion: MoveTo 184 137 self)
			)
			(3 (= seconds 3))
			(4
				(aJodi loop: 4 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(proc0_19 64)
				(if
					(or
						(& (gEgo onControl:) $0040)
						(& (gEgo onControl:) $0008)
					)
					(proc255_0 253 48)
				)
				(= seconds 3)
			)
			(6
				(aJodi
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 184 143 self
				)
			)
			(7
				(aJodi setMotion: MoveTo (aBill x?) 143 self)
			)
			(8
				(BillScript changeState: 2)
				(aJodi setMotion: MoveTo -10 143 self)
			)
			(9
				(aJodi dispose:)
				(self dispose:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((super handleEvent: pEvent))
			((Said '/body') (proc255_0 253 44 67 -1 144))
			((Said '/babe,blond')
				(cond 
					((< (aJodi y?) 0) (proc255_0 253 45))
					((and (> state 3) (< state 6)) (proc255_0 253 46))
					(else (proc255_0 253 47))
				)
			)
		)
	)
)

(instance aBill of Prop
	(properties
		y 140
		x 160
		view 253
		loop 5
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 setScript: BillScript stopUpd:)
	)
)

(instance alsHead of View
	(properties
		y 96
		x 138
		view 253
		loop 3
		priority 6
		signal $4101
	)
)

(instance alsFeet of View
	(properties
		y 132
		x 138
		view 253
		loop 4
		priority 9
		signal $4101
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 240
		view 257
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 240
		view 257
		loop 1
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(proc0_19 30)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)
