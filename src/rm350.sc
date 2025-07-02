;;; Sierra Script 1.0 - (do not remove this comment)
(script# 350)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm350 0
)
(synonyms
	(man attendant dave)
)

(local
	local0
)
(instance rm350 of Rm
	(properties
		picture 350
		east 305
		west 355
	)
	
	(method (init)
		(super init:)
		(gAddToPics
			add: atpChair1
			add: atpChair2
			add: atpChair3
			add: atpChair4
			add: atpTable1
			add: atpTable2
			add: atpTenPin
			doit:
		)
		(self setScript: RoomScript)
		(aDave init:)
		(aDoor init:)
		(aPins init:)
		(if (> global87 16)
			(aWaterfall setCycle: Fwd isExtra: 1 init:)
		)
		(cond 
			((== gGNumber 355)
				(proc0_3)
				(Load rsSOUND 350)
				(Load rsSOUND 351)
				(Load rsSOUND 11)
				(Load rsPIC 99)
				(aKen ignoreActors: setCycle: Walk setPri: 4 init:)
				(gEgo
					view: 351
					illegalBits: 0
					posn: 17 141
					setLoop: 0
					setCycle: Fwd
					setStep: 10 1
					init:
				)
				(DaveScript changeState: 3)
				(RoomScript changeState: 9)
			)
			((not (proc0_22 23))
				(proc0_3)
				(proc0_19 17)
				(proc0_19 19)
				(proc0_19 20)
				(proc0_19 21)
				(proc0_19 22)
				(proc0_19 23)
				(= gGNumber_2 4)
				(gEgo illegalBits: 0 loop: 1 posn: 295 144 init:)
				(RoomScript changeState: 1)
			)
			(else
				(proc0_1 1)
				(gEgo observeControl: 16384 posn: 295 144 init:)
			)
		)
		(gTheMusic number: 32 loop: global72 play:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gEgo setMotion: MoveTo 293 144 self)
			)
			(2
				(gEgo setMotion: MoveTo 281 144 self)
			)
			(3
				(proc255_0 350 27)
				(gEgo setMotion: MoveTo 225 166 self)
			)
			(4
				(proc255_0 350 28)
				(gEgo setMotion: MoveTo 123 166 self)
			)
			(5
				(proc255_0 350 29)
				(proc255_0 350 30)
				(gEgo setPri: -1 setMotion: MoveTo 53 138 self)
			)
			(6
				(gEgo loop: 1)
				(aDoor setCycle: End self)
			)
			(7
				(aDoor stopUpd:)
				(gEgo setMotion: MoveTo -10 141)
			)
			(8)
			(9
				(gEgo setMotion: MoveTo 192 141 self)
				(aKen setMotion: MoveTo 35 141)
				(gTheSoundFX number: 350 loop: 1 play:)
			)
			(10
				(gEgo
					setPri: 10
					setLoop: 1
					cel: 0
					setCycle: End
					setMotion: MoveTo 255 137 self
				)
				(aPins setCycle: End)
				(gTheMusic stop:)
				(gTheSoundFX stop: number: 351 loop: 1 play:)
			)
			(11
				(gTheSoundFX fade:)
				(aPins stopUpd:)
				(gEgo stopUpd:)
				(= seconds 2)
			)
			(12
				(proc255_4 350 31 global170)
				(= seconds 2)
			)
			(13
				(proc255_0 350 32)
				(aKen setMotion: MoveTo 0 141 self)
			)
			(14
				(aKen dispose:)
				(aDoor setCycle: Beg self)
				(proc255_0 350 33)
				(proc255_0 350 34)
				(= seconds 3)
			)
			(15
				(gTheSoundFX number: 11 loop: 1 play:)
			)
			(16
				(global2 drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= cycles 20)
			)
			(17
				(proc255_0 350 35)
				(= gGNumber_2 4)
				(global2 newRoom: 305)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'lie') (proc255_0 350 0) (proc255_0 350 1))
			((Said 'open/door') (proc255_0 350 2) (proc255_0 350 3 67 -1 144))
			((Said 'drink,get/water') (proc255_0 350 4) (proc255_0 350 5))
			((Said 'get') (proc255_0 350 6))
			((Said 'give') (proc255_0 350 7))
			((Said 'address/man,guard')
				(switch (++ local0)
					(1
						(proc255_0 350 8)
						(proc255_0 350 9)
					)
					(2
						(proc255_0 350 10)
						(proc255_0 350 11)
					)
					(else 
						(proc255_0 350 12)
						(proc255_0 350 13)
					)
				)
			)
			((or (Said '//job') (Said '/job')) (proc255_0 350 14))
			((or (Said '/chairman') (Said '//chairman')) (proc255_0 350 15) (proc255_0 350 16 67 -1 144))
			((Said 'look>')
				(cond 
					((Said '/clit,skin,carpet,(head<skin),skin') (proc255_0 350 17) (proc255_0 350 18 67 -1 144))
					((Said '/barstool,book') (proc255_4 350 19 global82))
					((Said '/cup') (proc255_0 350 20))
					((Said '/flower') (proc255_0 350 21))
					((Said '/water,fountain,cascade') (proc255_0 350 22))
					((Said '/buffet') (proc255_0 350 23))
					((Said '/guard,man') (proc255_0 350 24))
					((Said '/door') (proc255_0 350 25))
					((Said '[/area]') (proc255_0 350 26))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 99)
						(< (pEvent x?) 187)
						(> (pEvent y?) 130)
						(< (pEvent y?) 153)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 350 17)
							(proc255_0 350 18 67 -1 144)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(or
						(proc0_26 atpTable1 (pEvent x?) (pEvent y?))
						(proc0_26 atpTable2 (pEvent x?) (pEvent y?))
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 350 23))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 277)
						(< (pEvent x?) 318)
						(> (pEvent y?) 86)
						(< (pEvent y?) 150)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 286 181 self)
							(gEgo setMotion: MoveTo 321 140)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 27)
						(< (pEvent x?) 41)
						(> (pEvent y?) 83)
						(< (pEvent y?) 131)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 350 2)
							(proc255_0 350 3 67 -1 144)
						)
						(995 (proc255_0 350 25))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(or
						(proc0_26 atpChair1 (pEvent x?) (pEvent y?))
						(proc0_26 atpChair2 (pEvent x?) (pEvent y?))
						(proc0_26 atpChair3 (pEvent x?) (pEvent y?))
						(proc0_26 atpChair4 (pEvent x?) (pEvent y?))
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(proc255_0 350 0)
							(proc255_0 350 1)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aDave (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(996
							(pEvent type: 1 claimed: 1)
							(switch (++ local0)
								(1
									(proc255_0 350 8)
									(proc255_0 350 9)
								)
								(2
									(proc255_0 350 10)
									(proc255_0 350 11)
								)
								(else 
									(proc255_0 350 12)
									(proc255_0 350 13)
								)
							)
						)
						(998 (proc255_0 350 24))
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aWaterfall (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(pEvent type: 1 claimed: 1)
							(proc255_0 350 22)
						)
						(995
							(proc255_0 350 4)
							(proc255_0 350 5)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 81)
						(< (pEvent x?) 238)
						(> (pEvent y?) 23)
						(< (pEvent y?) 63)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 350 26))
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance atpChair1 of PV
	(properties
		y 124
		x 69
		view 350
		cel 1
	)
)

(instance atpChair2 of PV
	(properties
		y 126
		x 256
		view 350
		cel 2
	)
)

(instance atpChair3 of PV
	(properties
		y 168
		x 295
		view 350
		cel 3
	)
)

(instance atpChair4 of PV
	(properties
		y 168
		x 25
		view 350
	)
)

(instance atpTable1 of PV
	(properties
		y 108
		x 93
		view 350
		cel 4
	)
)

(instance atpTable2 of PV
	(properties
		y 109
		x 232
		view 350
		cel 5
	)
)

(instance aPins of Prop
	(properties
		y 132
		x 222
		view 350
		loop 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 ignoreActors: stopUpd:)
	)
)

(instance atpTenPin of PV
	(properties
		y 148
		x 239
		view 350
		loop 1
		priority 11
		signal $4000
	)
)

(instance aDave of Prop
	(properties
		y 169
		x 144
		view 353
	)
	
	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setPri: 15
			setScript: DaveScript
			ignoreActors:
		)
	)
)

(instance DaveScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== 0 (aDave loop?))
			(aDave
				cel:
					(cond 
						((< 80 (gEgo x?)) 0)
						((< 140 (gEgo x?)) 1)
						((< 180 (gEgo x?)) 2)
						((< 240 (gEgo x?)) 3)
						(else 4)
					)
			)
		)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0 (= cycles (Random 11 22)))
			(1
				(= seconds (Random 3 9))
				(switch (= temp0 (Random 0 5))
					(0
						(aDave loop: 1 setCycle: End self)
						(= seconds 0)
					)
					(1
						(aDave loop: 2 setCycle: End)
					)
					(else 
						(aDave loop: 0)
						(= state -1)
					)
				)
			)
			(2
				(aDave setCycle: Beg self)
				(= state -1)
			)
			(3
				(aDave loop: 0)
				(= seconds (= cycles 0))
			)
		)
	)
)

(instance aKen of Act
	(properties
		y 141
		x 17
		view 352
		illegalBits $0000
	)
)

(instance aWaterfall of Prop
	(properties
		y 103
		x 163
		view 350
		loop 3
	)
)

(instance aDoor of Prop
	(properties
		y 94
		x 29
		view 350
		loop 4
	)
	
	(method (init)
		(super init:)
		(self
			setCel: (if (== gGNumber 355) 255 else 0)
			ignoreActors:
			stopUpd:
		)
	)
)
