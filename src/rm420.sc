;;; Sierra Script 1.0 - (do not remove this comment)
(script# 420)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use DCIcon)
(use Follow)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm420 0
)
(synonyms
	(man guard man man man bouncer)
	(babe babe dale cheri)
)

(local
	[local0 166]
	[local166 22]
	local188
	local189
	[local190 24] = [0 0 0 741 0 -9725 30004 0 0 18608 25695 -32695 993 0 0 9170 0 0 -16422 -31742 0 0 -10054 -3033]
	local214
)
(procedure (localproc_0032 param1 param2 param3)
	(proc255_0
		@local0
		67
		-1
		10
		80
		{El Maitre d' dice}
		30
		1
		82
		param1
		param2
		param3
	)
	(= local0 0)
)

(instance rm420 of Rm
	(properties
		picture 420
		east 415
	)
	
	(method (init)
		(Load rsSOUND 11)
		(if (gEgo has: 7) (Load rsVIEW 7))
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(gAddToPics
			add: atpPoster1
			add: atpPoster2
			add: atpPhone
			add: atpPodium
			doit:
		)
		(aRope init:)
		(aDoor init:)
		(proc0_1)
		(gEgo observeControl: 16384 8192 init:)
		(self setScript: RoomScript)
		(if
			(or
				(== gGNumber 430)
				(== gGNumber 431)
				(== global104 0)
			)
			(aMaitreD view: 422 setPri: 5 setLoop: 2 init:)
		)
		(if (< global104 3) (aManager init:) (= gADoor aDoor))
		(if
		(or (== global104 1) (== global104 2) (== global104 3))
			(aCherri init:)
			(= gADoor aDoor)
		)
		(cond 
			((== gGNumber 440)
				(if (== gGNumber_2 18) (= gGNumber_2 0))
				(TheMenuBar draw:)
				(SL enable:)
				(gEgo loop: 0 posn: 44 142)
			)
			((== gGNumber 435)
				(= gGNumber_2 0)
				(gEgo
					loop: gGEgoLoop
					posn: (if gGEgoX else 99) (if gGEgoY else 124)
				)
				(aCherri init:)
			)
			((== gGNumber 430) (RoomScript changeState: 1))
			((== gGNumber 431) (self style: 7) (RoomScript changeState: 1))
			((> (gEgo y?) 130) (gEgo posn: 317 188 loop: 1))
			(else (gEgo loop: 1 posn: 309 163))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== gADoor aDoor)
			(= gADoor 0)
			(DisposeScript 421)
			(DisposeScript 422)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(TheMenuBar draw:)
				(SL enable:)
				(aRope setCel: 255 stopUpd:)
				(aMaitreD view: 422 posn: 125 109 setPri: 5 init:)
				(proc0_1 2)
				(proc0_3)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					posn: 150 94
					setMotion: MoveTo 150 114 self
				)
			)
			(2
				(gEgo stopUpd:)
				(aRope setCycle: Beg)
				(aMaitreD
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 172 105 self
				)
			)
			(3
				(aMaitreD setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(aMaitreD setCel: 0 stopUpd:)
				(aRope stopUpd:)
				(proc0_1)
				(gEgo observeControl: 16384 8192)
				(if (== gGNumber 430)
					(proc255_0 420 20)
				else
					(proc255_0 420 21)
					(= seconds 2)
				)
			)
			(5
				(proc255_0 420 22)
				(proc255_0 420 23 67 -1 144)
			)
			(6
				(proc0_6)
				(proc0_3)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 44 140 self
				)
			)
			(7
				(aDoor setCycle: End self)
				(gEgo setLoop: 1)
			)
			(8
				(gEgo setMotion: MoveTo -3 140 self)
			)
			(9 (aDoor setCycle: Beg self))
			(10
				(gTheSoundFX number: 11 loop: 1 play:)
				(= cycles 12)
			)
			(11 (global2 newRoom: 440))
			(12
				(proc0_3)
				(aCherri setScript: 0)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 50 143 self
				)
			)
			(13
				(gEgo loop: 1)
				(= cycles 11)
			)
			(14
				(if (== global104 4)
					(proc255_0 420 24)
					(= seconds 3)
				else
					(= cycles (= seconds 0))
					((aManager script?) cue:)
					(self dispose:)
				)
			)
			(15
				(proc255_0 420 25)
				(proc255_0 420 26)
				(proc255_0 420 27)
				(= seconds 3)
			)
			(16
				(proc255_0 420 28)
				(proc255_0 420 29)
				(= seconds 3)
			)
			(17
				(proc255_0 420 30)
				(if (gEgo has: 7) (= state 19))
				(= seconds 3)
			)
			(18
				(proc255_0 420 31)
				(= seconds 3)
			)
			(19
				(proc255_0 420 32)
				(proc255_0 420 33)
				(proc0_1)
				(gEgo observeControl: 16384 8192)
			)
			(20
				(proc255_0 420 34 82 7 0 0)
				(proc0_24 7)
				(gGame changeScore: 25)
				(= seconds 3)
			)
			(21
				(proc255_0 420 35 67 10 5 70 290)
				(= seconds 3)
			)
			(22 (aDoor setCycle: End self))
			(23
				(aDoor stopUpd:)
				(gEgo setMotion: MoveTo -20 (gEgo y?) self)
			)
			(24 (aDoor setCycle: Beg self))
			(25
				(gTheSoundFX number: 11 loop: 1 play:)
				(proc0_5)
				(proc255_0 420 36)
				(global2 newRoom: 440)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'look/art,art') (proc255_0 420 0))
			(
			(or (Said 'make/call') (Said 'call') (Said 'use/call'))
				(if (== global104 2)
					(proc255_0 420 1)
				else
					(proc255_0 420 2)
				)
			)
			((Said '/alter') (proc255_0 420 3))
			((Said 'unbolt/door') (proc255_0 420 4))
			((Said 'open/door')
				(cond 
					((not (& (gEgo onControl:) $0008)) (proc0_10))
					((== gGNumber_2 11) (self changeState: 6))
					(else (proc255_0 420 5))
				)
			)
			((and (== gGNumber_2 11) (Said '/cloth,cloth')) (proc255_0 420 6))
			((Said 'knock')
				(cond 
					((== gGNumber_2 11) (proc255_0 420 7))
					((or (proc0_22 35) (>= global104 6)) (proc255_0 420 8))
					((not (& (gEgo onControl:) $0008)) (proc0_10))
					((== global104 1) (proc255_0 420 9))
					(else (self changeState: 12))
				)
			)
			((Said 'look<in/bolt,(hole<key),door')
				(if (not (& (gEgo onControl:) $0008))
					(proc0_10)
				else
					(proc255_0 420 10)
				)
			)
			((Said 'look,look/awning,door')
				(if (not (& (gEgo onControl:) $0008))
					(proc0_10)
				else
					(proc255_0 420 11)
				)
			)
			((Said 'board/backstage') (proc255_0 420 12))
			((Said '/hemp') (proc255_0 420 13))
			((Said 'look>')
				(cond 
					((Said '/lectern')
						(if (== global104 2)
							(proc255_0 420 14)
						else
							(proc255_0 420 15)
						)
					)
					((Said '/backstage') (proc255_0 420 16))
					((Said '/wall') (proc255_0 420 0) (proc255_0 420 17))
					((Said '/call')
						(if (== global104 2)
							(proc255_0 420 18)
						else
							(proc255_0 420 17)
						)
					)
					((Said '[/area]')
						(proc255_0
							(Format
								@local0
								420
								19
								(cond 
									((== global104 2) {una hermosa mujer en bata})
									((gCast contains: aMaitreD) {un hombre detr*s de un podio})
									(else {ti})
								)
							)
						)
					)
				)
			)
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 292)
					(< (pEvent x?) 319)
					(> (pEvent y?) 133)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 324 187 self)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(proc0_26 aMaitreD (pEvent x?) (pEvent y?))
					(gCast contains: aMaitreD)
				)
				(switch gCursorNumber
					(996
						(pEvent claimed: 1)
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							((not (& (gEgo onControl:) $0010)) (proc255_0 420 50))
							((>= global104 5) (proc255_0 420 44))
							((>= global104 1) (proc255_0 420 45))
							(local214
								(= temp0
									(proc255_0
										{&Sobre qu+ quieres hablar?}
										81
										{Cup>n}
										1
										81
										{Bar}
										2
										81
										{Casino}
										3
										81
										{Espect*culo}
										4
									)
								)
								(switch temp0
									(1
										(cond 
											((!= gGNumber_2 0) (proc0_9))
											((not (& (gEgo onControl:) $0010)) (proc255_0 420 47))
											((>= global104 5) (proc255_0 420 44))
											((>= global104 1) (proc255_0 420 45))
											(else (MaitreDScript changeState: 3))
										)
									)
									(2
										(if (not global108)
											(if
												(cond 
													((!= gGNumber_2 0) (proc0_9))
													((not (& (gEgo onControl:) $0010)) (proc255_0 420 37))
													(else
														(proc255_0 420 40)
														(Format @local0 420 41)
														(MaitreDScript changeState: 4)
													)
												)
												1
											)
										)
									)
									(3
										(cond 
											((!= gGNumber_2 0) (proc0_9))
											((not (& (gEgo onControl:) $0010)) (proc255_0 420 37))
											(else
												(proc255_0 420 42)
												(Format @local0 420 43)
												(MaitreDScript changeState: 4)
											)
										)
									)
									(4
										(cond 
											((!= gGNumber_2 0) (proc0_9))
											((not (& (gEgo onControl:) $0010)) (proc255_0 420 37))
											((>= global104 5) (proc255_0 420 44))
											((>= global104 1) (proc255_0 420 45))
											(else (Format @local0 420 46) (MaitreDScript changeState: 4))
										)
									)
								)
							)
							(else
								(= local214 1)
								(proc255_4 420 51 global171)
								(proc255_0 420 52)
								(Format @local0 420 46)
								(MaitreDScript changeState: 4)
							)
						)
					)
					(998
						(pEvent claimed: 1)
						(proc255_0 420 53)
						(proc255_0 420 54 67 -1 144)
					)
					(6
						(pEvent claimed: 1)
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							((not (& (gEgo onControl:) $0010)) (proc255_0 420 47))
							((>= global104 5) (proc255_0 420 44))
							((>= global104 1) (proc255_0 420 45))
							(else
								(= gGCursorNumber 900)
								(gGame setCursor: 998 (HaveMouse))
								(MaitreDScript changeState: 3)
							)
						)
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							((not (gEgo has: 6)) (proc255_0 420 48))
							((not (& (gEgo onControl:) $0010)) (proc255_0 420 47))
							((>= global104 5) (proc255_0 420 49))
							(else (MaitreDScript changeState: 6))
						)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 19)
					(< (pEvent x?) 42)
					(> (pEvent y?) 85)
					(< (pEvent y?) 131)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(7
						(cond 
							((== gGNumber_2 11) (proc255_0 420 7))
							((or (proc0_22 35) (>= global104 6)) (proc255_0 420 8))
							((not (& (gEgo onControl:) $0008)) (proc0_10))
							((== global104 1) (proc255_0 420 9))
							(else
								(= gGCursorNumber 900)
								(gGame setCursor: 998 (HaveMouse))
								(self changeState: 12)
							)
						)
					)
					(995
						(cond 
							((== gGNumber_2 11) (proc255_0 420 7) (self changeState: 6))
							((or (proc0_22 35) (>= global104 6)) (proc255_0 420 8))
							((not (& (gEgo onControl:) $0008)) (proc0_10))
							((== global104 1) (proc255_0 420 9))
							(else
								(= gGCursorNumber 900)
								(gGame setCursor: 998 (HaveMouse))
								(self changeState: 12)
							)
						)
					)
					(994 (proc255_0 420 4))
					(else  (pEvent claimed: 0))
				)
			)
			(if (proc0_26 atpPoster1 (pEvent x?) (pEvent y?))
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995)
					(998 (proc255_0 420 0))
					(994)
					(else  (pEvent claimed: 0))
				)
			)
			(if (proc0_26 atpPoster2 (pEvent x?) (pEvent y?))
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995)
					(998 (proc255_0 420 0))
					(994)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 297)
					(< (pEvent x?) 300)
					(> (pEvent y?) 149)
					(< (pEvent y?) 188)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(proc255_0
							(Format
								@local0
								420
								19
								(cond 
									((== global104 2) {una hermosa mujer en bata})
									((gCast contains: aMaitreD) {un hombre detr*s de un podio})
									(else {ti})
								)
							)
						)
					)
					(994)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 64)
					(< (pEvent x?) 73)
					(> (pEvent y?) 73)
					(< (pEvent y?) 94)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995 (proc255_0 420 3))
					(998
						(if (== global104 2)
							(proc255_0 420 1)
						else
							(proc255_0 420 2)
						)
					)
					(994)
					(996)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(proc0_26 aCherri (pEvent x?) (pEvent y?))
					(gCast contains: aCherri)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995)
					(998
						(cond 
							((!= global104 2) (proc255_0 422 1))
							((!= gGNumber_2 0) (proc0_9))
							((!= (aCherri xLast?) (aCherri x?)) (proc255_0 422 2))
							((not (& (gEgo onControl:) $0020)) (proc255_0 422 3))
							(else
								(CherriScript2 changeState: 1)
								(CherriScript2 changeState: 2)
							)
						)
					)
					(994)
					(996)
					(2 (proc255_0 420 58))
					(4 (proc255_0 420 59))
					(3 (proc255_0 420 60))
					(11 (proc255_0 420 61))
					(1 (proc255_0 420 62))
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)

(instance CherriScript2 of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (and (== state 10) (> (gEgo x?) 280))
			(CherriScript2 cue:)
		)
		(if
			(and
				(== global104 2)
				(== (aCherri loop?) 4)
				(== (aCherri x?) 82)
				(== (aCherri y?) 124)
			)
			(switch (Random 0 6)
				(0 (aCherri setCel: 0))
				(1 (aCherri setCycle: Fwd))
			)
		)
	)
	
	(method (changeState newState)
		(proc21_1 self newState 3 2)
		(switch (= state newState)
			(0
				(if (== global104 3) (CherriScript2 changeState: 3))
				(if (== global104 1)
					(CherriScript2 changeState: 10)
					(aCherri posn: -20 143 stopUpd:)
				)
			)
			(1
				(proc0_6)
				(proc0_3)
				(= gGNumber_2 14)
				(proc255_4 422 5 global171)
				(aCherri setStep: 0 0 setMotion: Follow gEgo 222)
				(= seconds 3)
			)
			(2
				(if (not (proc0_22 48))
					(proc0_19 48)
					(gGame changeScore: 5)
				)
				(proc255_0 422 6)
				(= gGEgoX (gEgo x?))
				(= gGEgoY (gEgo y?))
				(= gGEgoLoop (gEgo loop?))
				(global2 newRoom: 435)
			)
			(3 (proc0_3) (= seconds 3))
			(4
				(proc255_0 422 7)
				(= seconds 3)
			)
			(5
				(proc255_0 422 8)
				(aCherri
					illegalBits: 0
					ignoreActors: 0
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 45 140 self
				)
				(if
					(and
						(> (gEgo y?) (aCherri y?))
						(< (gEgo x?) (+ (aCherri x?) 15))
					)
					(gEgo setCycle: Walk setMotion: MoveTo 97 (gEgo y?))
				)
			)
			(6 (gADoor setCycle: End self))
			(7
				(proc255_0 422 9)
				(gADoor stopUpd:)
				(aCherri setMotion: MoveTo -20 140 self)
			)
			(8 (gADoor setCycle: Beg self))
			(9
				(gTheSoundFX number: 11 loop: 1 play:)
				(= global104 4)
				(gADoor stopUpd:)
				(proc0_1)
				(gEgo observeControl: 16384 8192)
				(aCherri dispose:)
				(self dispose:)
			)
			(10 (= seconds 15))
			(11
				(if (< (gEgo x?) 160)
					(-- state)
					(= cycles 2)
				else
					(proc0_3)
					(gADoor setCycle: End self)
					(= seconds 0)
				)
			)
			(12
				(gADoor stopUpd:)
				(aCherri
					posn: 13 140
					loop: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 45 140 self
				)
			)
			(13 (gADoor setCycle: Beg self))
			(14
				(gTheSoundFX number: 11 loop: 1 play:)
				(gADoor stopUpd:)
				(aCherri setMotion: MoveTo 82 124 self)
			)
			(15
				(aCherri loop: 4)
				(= global104 2)
				(proc0_4)
				(gEgo observeControl: 16384 8192)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(!= (pEvent type?) evSAID)
				(!= global104 2)
				(pEvent claimed?)
			)
			(return)
		)
		(cond 
			((or (Said 'give/babe') (Said 'give/*/babe')) (proc255_0 422 0))
			((Said 'look/babe')
				(cond 
					((!= global104 2) (proc255_0 422 1))
					((!= gGNumber_2 0) (proc0_9))
					((!= (aCherri xLast?) (aCherri x?)) (proc255_0 422 2))
					((not (& (gEgo onControl:) $0020)) (proc255_0 422 3))
					(else (CherriScript2 changeState: 1))
				)
			)
			((and (== global104 2) (Said '/babe')) (proc255_0 422 4))
		)
	)
)

(instance aMaitreD of Act
	(properties
		y 105
		x 172
		view 422
		loop 2
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setScript: MaitreDScript ignoreActors: stopUpd:)
	)
)

(instance MaitreDScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 5])
		(proc21_1 self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(proc0_6)
				(proc0_3)
				(proc255_0 420 64)
				(aMaitreD setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(while (== 0 [local190 local188])
					(= local188 (Random 1 24))
				)
				(Format @local0 420 65 local188)
				(localproc_0032 422 3 0)
				(= temp0 0)
				(proc255_2 @temp0 7 {Mi pase es:})
				(if
					(!=
						(= local189 (ReadNumber @temp0))
						[local190 local188]
					)
					(= state 12)
				)
				(if global64
					(proc255_4 420 66 local189 [local190 local188] local188)
				)
				(Format @local0 420 67)
				(localproc_0032 422 3 0)
				(= seconds 3)
			)
			(3
				(aMaitreD setCel: 0 stopUpd:)
				(proc0_19 46)
				(if (not (proc0_22 47))
					(Format @local0 420 68)
					(handIcon view: 422 loop: 4)
					(proc255_0
						@local0
						67
						-1
						10
						80
						{El Maitre d' dice}
						30
						1
						82
						handIcon
					)
					(= local0 0)
					(proc0_4)
				else
					(Format @local0 420 69)
					(localproc_0032 422 3 6)
					(self changeState: 8)
				)
			)
			(4
				(proc0_3)
				(aMaitreD setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(aMaitreD setCel: 0 stopUpd:)
				(if (not local0) (Format @local0 420 70))
				(localproc_0032 422 3 0)
				(proc0_4)
			)
			(6
				(proc0_3)
				(aMaitreD setLoop: 2 setCycle: Fwd)
				(= cycles 0)
				(= seconds 3)
			)
			(7
				(aMaitreD setCel: 0 stopUpd:)
				(cond 
					((== ((Inv at: 6) view?) 24) (proc255_0 420 71) (localproc_0032 422 3 0))
					((not (proc0_22 46))
						(Format @local0 420 72)
						(localproc_0032 422 3 1)
						(proc0_24 6)
						(gGame changeScore: 50)
						(proc0_19 47)
						(proc0_4)
					)
					(else
						(proc0_3)
						(Format @local0 420 72)
						(localproc_0032 422 3 1)
						(proc0_24 6)
						(proc0_19 47)
						(gGame changeScore: 50)
						(= seconds 2)
					)
				)
			)
			(8
				(aMaitreD
					illegalBits: 0
					ignoreActors: 1
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 162 105 self
				)
			)
			(9
				(aMaitreD setMotion: MoveTo 125 109 self)
				(aRope cycleSpeed: 1 setCycle: End)
			)
			(10
				(aRope stopUpd:)
				(aMaitreD setLoop: 2 setCel: 0 stopUpd:)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 149 114 self
				)
			)
			(11
				(gEgo setMotion: MoveTo 149 94 self)
			)
			(12 (global2 newRoom: 430))
			(13
				(aMaitreD setCel: 0 stopUpd:)
				(Format @local0 420 74)
				(localproc_0032 422 3 0)
				(= seconds 2)
			)
			(14
				(Format @local0 420 75)
				(localproc_0032 422 3 0)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 56
					register: (Format @local0 420 76)
					next: (Format @local166 420 77)
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp gInvSaidMe)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((or (Said 'ask/pass') (Said 'ask/about/pass'))
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 37))
					(else
						(proc255_0 420 38)
						(Format @local0 420 39)
						(self changeState: 4)
					)
				)
			)
			((and (not global108) (Said '/entertainer'))
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 37))
					(else
						(proc255_0 420 40)
						(Format @local0 420 41)
						(self changeState: 4)
					)
				)
			)
			(
				(or
					(Said '/casino,gambling')
					(Said 'gamble')
					(Said '//casino,gambling')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 37))
					(else
						(proc255_0 420 42)
						(Format @local0 420 43)
						(self changeState: 4)
					)
				)
			)
			(
				(or
					(Said 'board/backstage')
					(Said 'ask/show')
					(Said 'ask//show')
					(Said 'look/show')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 37))
					((>= global104 5) (proc255_0 420 44))
					((>= global104 1) (proc255_0 420 45))
					(else (Format @local0 420 46) (self changeState: 4))
				)
			)
			((Said 'bracelet,use,give,show/pass,book')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 47))
					((>= global104 5) (proc255_0 420 44))
					((>= global104 1) (proc255_0 420 45))
					(else (self changeState: 1))
				)
			)
			(
				(or
					(Said 'bracelet,give,show/buck,bill')
					(Said 'buy,tip/man')
					(Said 'bracelet,give,show/man/buck,bill')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (gEgo has: 6)) (proc255_0 420 48))
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 47))
					((>= global104 5) (proc255_0 420 49))
					(else (self changeState: 6))
				)
			)
			((Said 'address/man')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 50))
					((>= global104 5) (proc255_0 420 44))
					((>= global104 1) (proc255_0 420 45))
					(else
						(proc255_4 420 51 global171)
						(proc255_0 420 52)
						(Format @local0 420 46)
						(self changeState: 4)
					)
				)
			)
			((Said 'look/man') (proc255_0 420 53) (proc255_0 420 54 67 -1 144))
			((Said 'give>')
				(= gInvSaidMe (gInv saidMe:))
				(pEvent claimed: 0)
				(cond 
					((not (& (gEgo onControl:) $0010)) (proc255_0 420 55))
					((Said '[/!*]') (proc255_0 420 56))
					((not gInvSaidMe) (proc255_0 420 57))
					((not (gInvSaidMe ownedBy: gEgo)) (proc0_12))
					((== gInvSaidMe (gInv at: 2)) (proc255_0 420 58))
					((== gInvSaidMe (gInv at: 4)) (proc255_0 420 59))
					((== gInvSaidMe (gInv at: 3)) (proc255_0 420 60))
					((== gInvSaidMe (gInv at: 11)) (proc255_0 420 61))
					((== gInvSaidMe (gInv at: 1)) (proc255_0 420 62))
					(else (proc255_0 420 63))
				)
				(pEvent claimed: 1)
			)
		)
	)
)

(instance atpPhone of PV
	(properties
		y 96
		x 70
		view 420
		loop 1
		cel 2
		priority 7
	)
)

(instance atpPoster1 of PV
	(properties
		y 87
		x 224
		view 420
		loop 1
		priority 7
	)
)

(instance atpPoster2 of PV
	(properties
		y 93
		x 279
		view 420
		loop 1
		cel 1
		priority 7
	)
)

(instance atpPodium of PV
	(properties
		y 109
		x 166
		view 420
		loop 2
		priority 6
		signal $4000
	)
)

(instance aRope of Prop
	(properties
		y 91
		x 106
		view 420
		loop 3
		signal $4000
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 6 stopUpd:)
	)
)

(instance aManager of Prop
	(properties
		y 1000
		x 1000
		view 421
	)
	
	(method (init)
		(super init:)
		(self setScript: (ScriptID 421) stopUpd:)
	)
)

(instance aDoor of Prop
	(properties
		y 132
		x 42
		view 420
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance aCherri of Act
	(properties
		y 124
		x 82
		view 436
		loop 1
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setScript: (ScriptID 422))
	)
)

(instance handIcon of DCIcon
	(properties)
)
