;;; Sierra Script 1.0 - (do not remove this comment)
(script# 360)
(include sci.sh)
(use Main)
(use Door)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm360 0
)
(synonyms
	(man man man attendant robin)
)

(local
	local0
	local1
	local2
)
(instance rm360 of Rm
	(properties
		picture 360
		horizon 111
		north 390
		east 365
		south 300
	)
	
	(method (init)
		(if (gEgo has: 9)
			(Load rsVIEW 715)
			(Load rsVIEW 9)
			(Load rsSOUND 11)
		)
		(super init:)
		(gAddToPics
			add: atpRightCardHole
			add: atpLeftCardHole
			add: atpRearCardHole
			add: atpFatCity
			add: atpBboard
			add: atpShelves
			add: atpSumtin
			add: atpBlender
			doit:
		)
		(aTanBoothDoor init:)
		(aStudioDoor init:)
		(aLockerDoor init:)
		(if (not global108) (aRobin init:))
		(self setLocales: 80 setScript: RoomScript)
		(proc0_1)
		(cond 
			((== gGNumber 390)
				(gEgo posn: 198 122 loop: 2)
				(aStudioDoor close: locked: 1)
				(if (== gGNumber_2 1)
					(proc0_3)
					(aBambi init:)
					(gEgo
						view: 720
						posn: 191 122
						illegalBits: 0
						ignoreActors:
					)
					(gTheMusic number: 399 loop: global72 play:)
					(RoomScript changeState: 11)
				)
			)
			((== gGNumber 370) (gEgo posn: 27 173) (aLockerDoor close: locked: 1))
			((== gGNumber 365)
				(TheMenuBar draw: state: 1)
				(SL enable:)
				(gEgo loop: 1 posn: 294 177)
			)
			(else (gEgo posn: 159 186 loop: 3))
		)
		(gEgo init:)
		(User canInput: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= gGNumber_2 1)
			(gEgo
				observeControl: (& (gEgo onControl:) $1000)
				ignoreControl: (& (gEgo onControl:) $0020)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 0))
			(1
				(proc0_3)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 60 160 self
				)
			)
			(2
				(gEgo view: 715 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(proc0_1)
				(proc0_3)
				(if (not (proc0_22 33))
					(proc0_19 33)
					(gGame changeScore: 3)
					(proc255_0 360 24 82 9 0 0)
				)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 12 171 self
				)
				(aLockerDoor locked: 0 force: 1 open:)
			)
			(4
				(gEgo setMotion: MoveTo 0 171 self)
			)
			(5
				(aLockerDoor force: 1 close:)
				(gTheSoundFX number: 11 loop: 1 play:)
				(gEgo setMotion: MoveTo -20 171 self)
			)
			(6 (global2 newRoom: 370))
			(7
				(proc0_3)
				(proc0_6)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 217 124 self
				)
			)
			(8
				(gEgo view: 715 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(9
				(if (not (proc0_22 34))
					(proc0_19 34)
					(gGame changeScore: 3)
					(proc255_0 360 24 82 9 0 0)
				)
				(proc0_1)
				(proc0_3)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 197 118 self
				)
				(aStudioDoor locked: 0 force: 1 open:)
			)
			(10
				(gEgo setMotion: MoveTo 197 0)
			)
			(11 (= cycles 10))
			(12
				(aBambi setMotion: MoveTo 225 165 self)
				(= cycles 5)
			)
			(13
				(gEgo setMotion: MoveTo 225 165 self)
			)
			(14
				(proc255_0 360 25)
				(proc255_0 360 26)
				(aBambi setMotion: MoveTo 294 176)
			)
			(15
				(gEgo setMotion: MoveTo 280 179 self)
			)
			(16
				(aBambi
					cycleSpeed: 3
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(17
				(gGame changeScore: 3)
				(= cycles 10)
			)
			(18
				(aBambi setCycle: Beg)
				(aTanBoothDoor setCycle: End self)
			)
			(19
				(aTanBoothDoor stopUpd:)
				(= cycles 20)
			)
			(20
				(proc255_0 360 27)
				(= cycles 10)
			)
			(21
				(aBambi
					cycleSpeed: 0
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 316 175 self
				)
			)
			(22
				(gEgo setMotion: MoveTo 333 174)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'use,backdrop/keycard,card')
					(Said 'backdrop,backdrop/keycard,card/door,hole')
					(Said 'backdrop,backdrop//keycard,card')
					(Said 'unbolt,open/door')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (gEgo has: 9)) (proc255_0 360 0))
					(
						(and
							(not (& (gEgo onControl:) (aLockerDoor doorCtrl?)))
							(not (& (gEgo onControl:) (aStudioDoor doorCtrl?)))
							(not (& (gEgo onControl:) $0020))
						)
						(proc0_10)
					)
					((& (gEgo onControl:) $0020) (proc255_0 360 1) (proc255_0 360 2))
					((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (RoomScript changeState: 1))
					((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (RoomScript changeState: 7))
				)
			)
			((Said '/club,class,bell,booth,aerobic') (proc255_0 360 3))
			((Said '/bookcase,buffet') (proc255_0 360 4))
			((Said '/blender') (proc255_0 360 5))
			((Said '/blouse') (proc255_0 360 6))
			((Said 'get/soap') (proc255_0 360 7))
			((Said 'look>')
				(cond 
					((Said '/door')
						(cond 
							((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (proc255_0 360 8))
							((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (proc255_0 360 9))
							((& (gEgo onControl:) $0020) (proc255_0 360 10))
							(else (proc255_0 360 11))
						)
					)
					((Said '/awning,board,note,art') (proc255_0 360 12))
					((Said '/man')
						(if (gCast contains: aRobin)
							(proc255_0 360 13)
						else
							(proc255_0 360 14)
						)
					)
					((Said '/buffet,buffet<behind,back')
						(if (gCast contains: aRobin)
							(proc255_0 360 15)
						else
							(proc255_0 360 16)
							(proc255_0 360 17)
						)
					)
					((Said '/buffet,buffet')
						(if global108
							(proc255_0 360 18)
						else
							(proc255_0 360 19)
						)
					)
					((Said '/burn') (proc255_0 360 20))
					((Said '/board,bulletin,note,awning') (proc255_0 360 21))
					((Said '/announcement') (proc255_0 360 22))
					((Said '[/club,club,area]') (proc255_0 360 23))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 24)
						(< (pEvent x?) 289)
						(> (pEvent y?) 182)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 157 192)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 57)
						(< (pEvent x?) 249)
						(> (pEvent y?) 122)
						(< (pEvent y?) 181)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 360 23))
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aRobin (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(if (gCast contains: aRobin)
								(proc255_0 360 13)
							else
								(proc255_0 360 14)
							)
						)
						(9
							(cond 
								((not (gEgo has: 9)) (proc0_12) (pEvent claimed: 1))
								((not (& (gEgo onControl:) $0080)) (proc0_10))
								(else
									(proc255_0 360 34 82 9 0 0)
									(ManScript changeState: 6 register: 101)
								)
							)
						)
						(996
							(= local1
								(proc255_6
									{&De qu+ quieres hablar?}
									81
									{Saludos}
									1
									81
									{Puertas}
									2
									81
									{Socio}
									3
									81
									{Combinaci>n}
									5
								)
							)
							(switch local1
								(1
									(cond 
										(global108 (proc255_0 360 28))
										((not (& (gEgo onControl:) $0080)) (proc0_10))
										(else (ManScript changeState: 6 register: (++ local0)))
									)
								)
								(2
									(proc255_0 360 29)
									(ManScript changeState: 6 register: 102)
								)
								(3
									(proc255_0 360 30)
									(ManScript changeState: 6 register: 104)
								)
								(5
									(proc255_0 360 32)
									(ManScript changeState: 6 register: 108)
								)
								(6
									(proc255_0 360 33)
									(ManScript changeState: 6 register: 107)
								)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aLockerDoor (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (proc255_0 360 8))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (proc255_0 360 9))
								((& (gEgo onControl:) $0020) (proc255_0 360 10))
								(else (proc255_0 360 11))
							)
						)
						(9
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (gEgo has: 9)) (proc255_0 360 0))
								((not (gEgo has: 8)) (proc255_0 370 55))
								(
									(and
										(not (& (gEgo onControl:) (aLockerDoor doorCtrl?)))
										(not (& (gEgo onControl:) (aStudioDoor doorCtrl?)))
										(not (& (gEgo onControl:) $0020))
									)
									(proc0_10)
								)
								((& (gEgo onControl:) $0020) (proc255_0 360 1) (proc255_0 360 2))
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (RoomScript changeState: 1))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (RoomScript changeState: 7))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
				(proc0_26 atpRearCardHole (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (proc255_0 360 8))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (proc255_0 360 9))
								((& (gEgo onControl:) $0020) (proc255_0 360 10))
								(else (proc255_0 360 11))
							)
						)
						(9
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (gEgo has: 9)) (proc255_0 360 0))
								(
									(and
										(not (& (gEgo onControl:) (aLockerDoor doorCtrl?)))
										(not (& (gEgo onControl:) (aStudioDoor doorCtrl?)))
										(not (& (gEgo onControl:) $0020))
									)
									(proc0_10)
								)
								((& (gEgo onControl:) $0020) (proc255_0 360 1) (proc255_0 360 2))
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (RoomScript changeState: 1))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (RoomScript changeState: 7))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
				(proc0_26 atpLeftCardHole (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (proc255_0 360 8))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (proc255_0 360 9))
								((& (gEgo onControl:) $0020) (proc255_0 360 10))
								(else (proc255_0 360 11))
							)
						)
						(9
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (gEgo has: 9)) (proc255_0 360 0))
								((not (gEgo has: 8)) (proc255_0 370 55))
								((not (gEgo has: 5)) (proc255_0 360 7))
								(
									(and
										(not (& (gEgo onControl:) (aLockerDoor doorCtrl?)))
										(not (& (gEgo onControl:) (aStudioDoor doorCtrl?)))
										(not (& (gEgo onControl:) $0020))
									)
									(proc0_10)
								)
								((& (gEgo onControl:) $0020) (proc255_0 360 1) (proc255_0 360 2))
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (RoomScript changeState: 1))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (RoomScript changeState: 7))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
				(proc0_26 atpRightCardHole (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (proc255_0 360 8))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (proc255_0 360 9))
								((& (gEgo onControl:) $0020) (proc255_0 360 10))
								(else (proc255_0 360 11))
							)
						)
						(9
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (gEgo has: 9)) (proc255_0 360 0))
								(
									(and
										(not (& (gEgo onControl:) (aLockerDoor doorCtrl?)))
										(not (& (gEgo onControl:) (aStudioDoor doorCtrl?)))
										(not (& (gEgo onControl:) $0020))
									)
									(proc0_10)
								)
								((& (gEgo onControl:) $0020) (proc255_0 360 1) (proc255_0 360 2))
								((& (gEgo onControl:) (aLockerDoor doorCtrl?)) (RoomScript changeState: 1))
								((& (gEgo onControl:) (aStudioDoor doorCtrl?)) (RoomScript changeState: 7))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 atpBboard (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 360 21)
							(proc255_0 360 22)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aRobin of Act
	(properties
		y 105
		x 133
		view 362
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			setPri: 10
			setCycle: Walk
			setScript: ManScript
		)
	)
)

(instance ManScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 4 8)))
			(1
				(aRobin
					illegalBits: 0
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (Random 101 155) 105 self
				)
			)
			(2 (= seconds (Random 1 3)))
			(4
				(aRobin setLoop: 3)
				(= seconds (Random 4 8))
				(= state -1)
			)
			(6
				(proc0_3)
				(= seconds 0)
				(aRobin setMotion: 0 setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(aRobin setCel: 0)
				(switch register
					(1 (proc255_0 360 36))
					(2 (proc255_0 360 37))
					(3 (proc255_0 360 38))
					(4
						(cond 
							((< global98 3) (proc255_0 360 39))
							((== global98 3) (proc255_0 360 40))
							(else (proc255_0 360 41))
						)
					)
					(101 (proc255_0 360 42))
					(102 (proc255_0 360 43))
					(103
						(proc255_0 360 44)
						(proc255_0 360 45)
					)
					(104 (proc255_0 360 46))
					(105 (proc255_0 360 47))
					(106 (proc255_0 360 48))
					(107 (proc255_0 360 49))
					(108 (proc255_0 360 50))
					(else 
						(proc255_0 360 51)
						(= local0 4)
					)
				)
				(= register 0)
				(proc0_4)
				(self changeState: 0)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'address/man')
				(cond 
					(global108 (proc255_0 360 28))
					((not (& (gEgo onControl:) $0080)) (proc0_10))
					(else (ManScript changeState: 6 register: (++ local0)))
				)
			)
			((Said 'ask>')
				(cond 
					(global108 (proc255_0 360 28))
					((not (& (gEgo onControl:) $0080)) (proc0_10))
					((or (Said '/door') (Said '//door'))
						(proc255_0 360 29)
						(ManScript changeState: 6 register: 102)
					)
					(
						(or
							(Said '/keycard,camp,key,membership,card')
							(Said 'enroll')
							(Said '//keycard,key,camp,membership,card')
						)
						(proc255_0 360 30)
						(ManScript changeState: 6 register: 104)
					)
					(
					(or (Said '/bambi,tape') (Said '//tape,bambi'))
						(proc255_0 360 31)
						(ManScript changeState: 6 register: 106)
					)
					((or (Said '/locker') (Said '//locker'))
						(proc255_0 360 32)
						(ManScript changeState: 6 register: 108)
					)
					(
					(or (Said '/combination') (Said '//combination'))
						(proc255_0 360 33)
						(ManScript changeState: 6 register: 107)
					)
					(else (ManScript changeState: 6 register: 103))
				)
				(pEvent claimed: 1)
			)
			((Said 'show/keycard')
				(cond 
					((not (gEgo has: 9)) (proc0_12) (pEvent claimed: 1))
					((not (& (gEgo onControl:) $0080)) (proc0_10))
					(else
						(proc255_0 360 34 82 9 0 0)
						(ManScript changeState: 6 register: 101)
					)
				)
			)
			((Said 'give')
				(if (& (gEgo onControl:) $0080)
					(ManScript changeState: 6 register: 105)
				else
					(proc0_10)
				)
			)
			((Said '/man') (proc255_0 360 35))
		)
	)
)

(instance aBambi of Act
	(properties
		y 126
		x 200
		view 393
		loop 2
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setCycle: Walk
		)
	)
)

(instance aTanBoothDoor of Prop
	(properties
		y 171
		x 302
		view 360
		loop 1
		cycleSpeed 2
	)
)

(instance aStudioDoor of Door
	(properties
		y 117
		x 198
		view 360
		loop 2
		entranceTo 390
		locked 1
		doorCtrl 8
		roomCtrl 16
		doorBlock 8192
	)
)

(instance aLockerDoor of Door
	(properties
		y 172
		x 19
		view 360
		entranceTo 370
		locked 1
		roomCtrl 0
	)
)

(instance atpRightCardHole of PV
	(properties
		y 165
		x 314
		view 360
		loop 3
		priority 14
	)
)

(instance atpLeftCardHole of PV
	(properties
		y 143
		x 43
		view 360
		loop 3
		cel 1
		priority 11
	)
)

(instance atpRearCardHole of PV
	(properties
		y 103
		x 224
		view 360
		loop 3
		cel 2
		priority 8
	)
)

(instance atpFatCity of PV
	(properties
		y 40
		x 129
		view 360
		loop 4
		priority 0
	)
)

(instance atpBboard of PV
	(properties
		y 134
		x 257
		view 360
		loop 4
		cel 1
		priority 9
	)
)

(instance atpShelves of PV
	(properties
		y 104
		x 131
		view 360
		loop 4
		cel 2
		priority 6
	)
)

(instance atpSumtin of PV
	(properties
		y 93
		x 170
		view 360
		loop 4
		cel 3
		priority 8
	)
)

(instance atpBlender of PV
	(properties
		y 109
		x 91
		view 360
		loop 4
		cel 4
		priority 9
	)
)
