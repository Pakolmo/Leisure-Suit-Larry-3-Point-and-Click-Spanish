;;; Sierra Script 1.0 - (do not remove this comment)
(script# 320)
(include sci.sh)
(use Main)
(use n021)
(use AutoDoor)
(use Class_255_0)
(use Extra)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm320 0
)
(synonyms
	(man hardy attendant man)
)

(local
	[local0 301]
	local301
	local302
)
(instance rm320 of Rm
	(properties
		picture 320
		south 310
	)
	
	(method (init)
		(if (= global94 500) (Load rsVIEW 24))
		(Load rsSOUND 323)
		(super init:)
		(gAddToPics
			add: atpDeskStuff
			add: atpPencils
			add: atpDCHSign
			add: atpSign
			add: atpFax
			doit:
		)
		(aDoor init: locked: 1)
		(if global108 (= global99 8))
		(if (< global99 8)
			(aRoger init:)
			(if (> global87 16) (aFax init:))
		)
		(self setScript: RoomScript)
		(if (or (== gGNumber 323) (== gGNumber 324))
			(gEgo loop: 2 posn: 153 96)
		else
			(gEgo loop: 3 posn: 156 186)
		)
		(if (!= gGNumber 323)
			(gTheMusic number: 323 loop: global72 play:)
		)
		(proc0_1)
		(gEgo init:)
	)
	
	(method (newRoom newRoomNumber)
		(cond 
			((and (== global99 2) (== (gEgo edgeHit?) 3)) (= global99 3))
			((and (== global99 6) (== (gEgo edgeHit?) 3)) (= global99 7))
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 4)
		(switch (= state newState)
			(0)
			(1)
			(2
				(proc0_3)
				(gGame changeScore: 10)
			)
			(3
				(proc0_3)
				(aDoor locked: 0)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo 233 (gEgo y?) self
				)
			)
			(4
				(gEgo setMotion: MoveTo 233 130 self)
				(if (== gGNumber_2 11)
					(Format @local0 320 15)
					(SecretaryScript changeState: 2)
				)
			)
			(5
				(gEgo setMotion: MoveTo 153 93 self)
			)
			(6
				(gEgo setMotion: MoveTo 153 87 self)
			)
			(7
				(if (== gGNumber_2 11)
					(global2 newRoom: 324)
				else
					(global2 newRoom: 323)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'get/palm') (proc255_0 320 0))
			((Said '/equipment') (proc255_0 320 1) (proc255_0 320 2 67 -1 144))
			((Said '/computer') (proc255_0 320 3))
			((Said '/call') (proc255_0 320 4))
			((Said 'look>')
				(cond 
					((Said '/palm') (proc255_0 320 5))
					((Said '/awning,wall') (proc255_0 320 6))
					((Said '/burn,ceiling') (proc255_0 320 7))
					((Said '/buffet,buffet,buffet') (proc255_0 320 8))
					((Said '/door')
						(cond 
							((& (gEgo onControl:) $0008) (proc255_0 320 9))
							((& (gEgo onControl:) $0002) (proc255_0 320 10))
							((& (gEgo onControl:) $0010) (proc255_0 320 11))
							(else (proc255_0 320 12))
						)
					)
					((Said '[/area]')
						(proc255_0 320 13)
						(if (gCast contains: aRoger) (proc255_0 320 14))
					)
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 93)
						(< (pEvent x?) 214)
						(> (pEvent y?) 175)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 146 195)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 9)
						(< (pEvent x?) 301)
						(> (pEvent y?) 21)
						(< (pEvent y?) 163)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 320 13)
							(if (gCast contains: aRoger) (proc255_0 320 14))
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 1)
						(< (pEvent x?) 42)
						(> (pEvent y?) 107)
						(< (pEvent y?) 180)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 320 5))
						(995 (proc255_0 320 0))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 277)
						(< (pEvent x?) 313)
						(> (pEvent y?) 117)
						(< (pEvent y?) 180)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 320 5))
						(995 (proc255_0 320 0))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(proc0_26 aRoger (pEvent x?) (pEvent y?))
						(gCast contains: aRoger)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 320 16))
						(24
							(cond 
								((not (gEgo has: 6)) (proc255_0 320 36))
								((not (& (gEgo onControl:) $0020)) (proc0_10))
								((and (!= gGNumber_2 0) (!= gGNumber_2 11)) (proc0_9))
								((!= local301 0) (proc255_0 320 17))
								((== global99 0)
									(User canInput: 0)
									(Format @local0 320 37)
									(self changeState: 2)
								)
								((== global99 1)
									(User canInput: 0)
									(Format @local0 320 38)
									(self changeState: 2)
								)
								((> global99 4)
									(User canInput: 0)
									(Format @local0 320 39)
									(self changeState: 2)
								)
								((!= global94 500) (proc255_0 320 40) (proc255_0 320 41 67 -1 144))
								(else
									(proc0_6)
									(= global99 5)
									(= global94 0)
									(gEgo put: 6 -1)
									(User canInput: 0)
									(proc255_0 320 42 82 24 0 0)
									(Format @local0 320 43)
									(RoomScript changeState: 2)
									(self changeState: 2)
									(= gGCursorNumber 900)
									(gGame setCursor: 998 (HaveMouse))
								)
							)
						)
						(996
							(= local302
								(proc255_0
									{&Sobre qu+ quieres hablar?}
									81
									{Divorcio}
									1
									81
									{Tierras}
									2
								)
							)
							(switch local302
								(1
									(cond 
										((not (& (gEgo onControl:) $0020)) (proc0_10))
										((and (!= gGNumber_2 0) (!= gGNumber_2 11)) (proc0_9))
										((!= local301 0) (proc255_0 320 17))
										((== global99 0)
											(User canInput: 0)
											(proc255_4 320 44 global171)
											(proc255_0 320 45)
											(Format @local0 320 46)
											(SecretaryScript changeState: 2)
										)
										((== global99 1)
											(User canInput: 0)
											(proc255_4 320 44 global171)
											(proc255_0 320 47)
											(Format @local0 320 48)
											(RoomScript changeState: 2)
											(SecretaryScript changeState: 2)
										)
										((== global99 2)
											(User canInput: 0)
											(proc255_0 320 49)
											(Format @local0 320 50)
											(SecretaryScript changeState: 2)
										)
										((< global99 6)
											(User canInput: 0)
											(proc255_0 320 51)
											(Format @local0 320 52)
											(SecretaryScript changeState: 2)
										)
										((< global99 7)
											(User canInput: 0)
											(proc255_0 320 53)
											(Format @local0 320 54)
											(SecretaryScript changeState: 2)
										)
										((> global99 7)
											(User canInput: 0)
											(proc255_0 320 55)
											(Format @local0 320 56)
											(SecretaryScript changeState: 2)
										)
										(else
											(User canInput: 0)
											(proc255_0 320 57)
											(Format
												@local0
												320
												58
												(if (proc0_22 45)
													{hacer negocios da placer}
												else
													{da placer hacer negocios}
												)
											)
											(= global99 8)
											(gEgo get: 10)
											(gGame changeScore: 20)
											(SecretaryScript changeState: 2)
										)
									)
								)
								(2
									(cond 
										((not (& (gEgo onControl:) $0020)) (proc0_10))
										((and (!= gGNumber_2 0) (!= gGNumber_2 11)) (proc0_9))
										((!= local301 0) (proc255_0 320 17))
										((== global99 0)
											(User canInput: 0)
											(proc255_4 320 44 global171)
											(proc255_0 320 59)
											(Format @local0 320 60)
											(SecretaryScript changeState: 2)
										)
										((== global99 1)
											(User canInput: 0)
											(proc255_4 320 44 global171)
											(proc255_0 320 61)
											(Format @local0 320 62)
											(RoomScript changeState: 2)
											(SecretaryScript changeState: 2)
										)
										((< global99 3)
											(User canInput: 0)
											(proc255_0 320 21)
											(Format @local0 320 22)
											(SecretaryScript changeState: 2)
										)
										((> global99 3)
											(User canInput: 0)
											(proc255_0 320 63)
											(Format @local0 320 64)
											(SecretaryScript changeState: 2)
										)
										(else
											(User canInput: 0)
											(proc255_0 320 65)
											(Format @local0 320 66)
											(= global99 4)
											(gEgo get: 7)
											(gGame changeScore: 20)
											(SecretaryScript changeState: 2)
										)
									)
								)
								(else  (pEvent claimed: 0))
							)
						)
					)
				)
			)
		)
	)
)

(instance SecretaryScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 2 2)
		(switch (= state newState)
			(0
				(aRoger cycleSpeed: 0 loop: 2 setCel: 0 setCycle: 0)
				(= local301 0)
				(= cycles 0)
				(= seconds (Random 3 6))
			)
			(1
				(if (== local301 0) (= local301 (Random 320 327)))
				(cond 
					((!= local0 0) (self changeState: 2))
					((== local301 320) (self changeState: 4))
					((== local301 323) (self changeState: 6))
					((== local301 321) (self changeState: 9))
					(else (self changeState: 0))
				)
			)
			(2
				(= local301 322)
				(aRoger loop: 3 setCycle: Fwd)
				(= cycles (Random 11 44))
			)
			(3
				(if (== local0 0)
					(switch (Random 1 5)
						(1 (Format @local0 320 67))
						(2 (Format @local0 320 68))
						(3 (Format @local0 320 69))
						(4 (Format @local0 320 70))
						(5 (Format @local0 320 71))
					)
				)
				(proc255_0
					@local0
					67
					-1
					10
					80
					{Roger dice}
					30
					1
					82
					321
					5
					0
				)
				(User canInput: 1)
				(if (== (RoomScript state?) 2) (RoomScript cue:))
				(= local0 0)
				(= cycles 22)
				(= state -1)
			)
			(4
				(aRoger loop: 2 setCycle: Fwd cycleSpeed: 1)
				(= cycles (Random 9 19))
			)
			(5
				(aRoger setCel: 0)
				(= cycles (Random 9 19))
				(if (Random 0 2) (= state 3) else (= state -1))
			)
			(6
				(aRoger cycleSpeed: 2 loop: 4 cel: 0 setCycle: End self)
			)
			(7 (= cycles (Random 9 19)))
			(8
				(aRoger setCycle: Beg self)
				(= state -1)
			)
			(9
				(aRoger cycleSpeed: 1 loop: 0 cel: 0 setCycle: End self)
			)
			(10
				(aRoger cycleSpeed: 1 loop: 1 setCycle: Fwd)
				(= cycles (Random 9 19))
			)
			(11
				(aRoger setCel: 0)
				(= cycles (Random 9 19))
				(if (Random 0 3) (= state 9))
			)
			(12
				(aRoger loop: 0 setCel: 255 setCycle: Beg self)
				(= state -1)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look/man') (proc255_0 320 16))
			(
				(or
					(Said '/appointment')
					(Said '//appointment')
					(Said 'address')
				)
				(cond 
					((not (& (gEgo onControl:) $0020)) (proc0_10))
					((and (!= gGNumber_2 0) (!= gGNumber_2 11)) (proc0_9))
					((!= local301 0) (proc255_0 320 17))
					(else
						(User canInput: 0)
						(switch global99
							(0
								(proc255_0 320 18)
								(Format @local0 320 19)
								(self changeState: 2)
							)
							(1
								(proc255_0 320 18)
								(Format @local0 320 20)
								(self changeState: 2)
							)
							(2
								(proc255_0 320 21)
								(Format @local0 320 22)
								(self changeState: 2)
							)
							(3
								(proc255_0 320 23)
								(Format @local0 320 24)
								(self changeState: 2)
							)
							(4
								(proc255_0 320 25)
								(Format @local0 320 26)
								(self changeState: 2)
							)
							(6
								(proc255_0 320 27)
								(Format @local0 320 28)
								(self changeState: 2)
							)
							(7
								(proc255_0 320 23)
								(Format @local0 320 24)
								(self changeState: 2)
							)
							(8
								(proc255_0 320 29)
								(Format @local0 320 30)
								(self changeState: 2)
							)
						)
					)
				)
			)
			(
				(and
					(gEgo has: 9)
					(or
						(Said '/keycard,(card<key,club,membership)')
						(Said '//keycard,(card<key,club,membership)')
					)
				)
				(proc255_0 320 31)
				(Format @local0 320 32)
			)
			(
			(or (Said '/entertainer') (Said '//entertainer'))
				(User canInput: 0)
				(proc255_0 320 33)
				(Format @local0 320 34)
				(self changeState: 2)
			)
			(
				(or
					(Said '/attorney,attorney,attorney')
					(Said '//attorney,attorney,attorney')
				)
				(User canInput: 0)
				(Format @local0 320 35)
				(self changeState: 2)
			)
			(
				(or
					(Said 'affirmative')
					(Said 'give,buy,use/buck,man,charge,bill')
				)
				(cond 
					((not (gEgo has: 6)) (proc255_0 320 36))
					((not (& (gEgo onControl:) $0020)) (proc0_10))
					((and (!= gGNumber_2 0) (!= gGNumber_2 11)) (proc0_9))
					((!= local301 0) (proc255_0 320 17))
					((== global99 0)
						(User canInput: 0)
						(Format @local0 320 37)
						(self changeState: 2)
					)
					((== global99 1)
						(User canInput: 0)
						(Format @local0 320 38)
						(self changeState: 2)
					)
					((> global99 4)
						(User canInput: 0)
						(Format @local0 320 39)
						(self changeState: 2)
					)
					((!= global94 500) (proc255_0 320 40) (proc255_0 320 41 67 -1 144))
					(else
						(proc0_6)
						(= global99 5)
						(= global94 0)
						(gEgo put: 6 -1)
						(User canInput: 0)
						(proc255_0 320 42 82 24 0 0)
						(Format @local0 320 43)
						(RoomScript changeState: 2)
						(self changeState: 2)
					)
				)
			)
			(
				(and
					(gEgo has: 10)
					(not (gEgo has: 9))
					(Said 'look,look/decree,document,document')
				)
				(pEvent claimed: 0)
				(return)
			)
			(
				(or
					(Said '/decree,document,(document<decree)')
					(Said '//decree,document,(document<decree)')
				)
				(cond 
					((not (& (gEgo onControl:) $0020)) (proc0_10))
					((and (!= gGNumber_2 0) (!= gGNumber_2 11)) (proc0_9))
					((!= local301 0) (proc255_0 320 17))
					((== global99 0)
						(User canInput: 0)
						(proc255_4 320 44 global171)
						(proc255_0 320 45)
						(Format @local0 320 46)
						(self changeState: 2)
					)
					((== global99 1)
						(User canInput: 0)
						(proc255_4 320 44 global171)
						(proc255_0 320 47)
						(Format @local0 320 48)
						(RoomScript changeState: 2)
						(self changeState: 2)
					)
					((== global99 2)
						(User canInput: 0)
						(proc255_0 320 49)
						(Format @local0 320 50)
						(self changeState: 2)
					)
					((< global99 6)
						(User canInput: 0)
						(proc255_0 320 51)
						(Format @local0 320 52)
						(self changeState: 2)
					)
					((< global99 7)
						(User canInput: 0)
						(proc255_0 320 53)
						(Format @local0 320 54)
						(self changeState: 2)
					)
					((> global99 7)
						(User canInput: 0)
						(proc255_0 320 55)
						(Format @local0 320 56)
						(self changeState: 2)
					)
					(else
						(User canInput: 0)
						(proc255_0 320 57)
						(Format
							@local0
							320
							58
							(if (proc0_22 45)
								{Hacer negocios dando placer}
							else
								{Dar placer haciendo negocios}
							)
						)
						(= global99 8)
						(gEgo get: 10)
						(gGame changeScore: 20)
						(self changeState: 2)
					)
				)
			)
			((and (gEgo has: 7) (Said 'look/deed,land')) (pEvent claimed: 0) (return))
			((or (Said '//deed,land') (Said '/deed,land'))
				(cond 
					((not (& (gEgo onControl:) $0020)) (proc0_10))
					((and (!= gGNumber_2 0) (!= gGNumber_2 11)) (proc0_9))
					((!= local301 0) (proc255_0 320 17))
					((== global99 0)
						(User canInput: 0)
						(proc255_4 320 44 global171)
						(proc255_0 320 59)
						(Format @local0 320 60)
						(self changeState: 2)
					)
					((== global99 1)
						(User canInput: 0)
						(proc255_4 320 44 global171)
						(proc255_0 320 61)
						(Format @local0 320 62)
						(RoomScript changeState: 2)
						(self changeState: 2)
					)
					((< global99 3)
						(User canInput: 0)
						(proc255_0 320 21)
						(Format @local0 320 22)
						(self changeState: 2)
					)
					((> global99 3)
						(User canInput: 0)
						(proc255_0 320 63)
						(Format @local0 320 64)
						(self changeState: 2)
					)
					(else
						(User canInput: 0)
						(proc255_0 320 65)
						(Format @local0 320 66)
						(= global99 4)
						(gEgo get: 7)
						(gGame changeScore: 20)
						(self changeState: 2)
					)
				)
			)
		)
	)
)

(instance atpSign of PV
	(properties
		y 125
		x 151
		view 320
		loop 1
		priority 9
		signal $4000
	)
)

(instance atpDCHSign of PV
	(properties
		y 93
		x 151
		view 320
		priority 9
		signal $4000
	)
)

(instance atpDeskStuff of PV
	(properties
		y 141
		x 165
		view 320
		loop 2
		priority 12
	)
)

(instance atpPencils of PV
	(properties
		y 136
		x 105
		view 320
		loop 2
		cel 1
		priority 12
	)
)

(instance atpFax of PV
	(properties
		y 142
		x 106
		view 320
		loop 4
		priority 12
		signal $4000
	)
)

(instance aFax of Extra
	(properties
		y 133
		x 106
		view 320
		loop 5
	)
	
	(method (init)
		(super init:)
		(self
			cycleType: 1
			pauseCel: -2
			minPause: 99
			maxPause: 999
			setPri: 12
			isExtra: 1
			ignoreActors:
			startExtra:
		)
	)
)

(instance aRoger of Prop
	(properties
		y 130
		x 146
		view 321
		loop 3
	)
	
	(method (init)
		(super init:)
		(self setPri: 12 setScript: SecretaryScript)
	)
)

(instance aDoor of AutoDoor
	(properties
		y 39
		x 153
		view 320
		entranceTo 323
	)
	
	(method (init)
		(super init:)
		(self setLoop: 3 setPri: 5)
	)
)
