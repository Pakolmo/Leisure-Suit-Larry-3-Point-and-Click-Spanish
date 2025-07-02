;;; Sierra Script 1.0 - (do not remove this comment)
(script# 323)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm323 0
)
(synonyms
	(babe attorney)
)

(local
	[local0 300]
	local300
	local301
	local302
)
(instance rm323 of Rm
	(properties
		picture 323
		west 320
	)
	
	(method (init)
		(Load rsVIEW 326)
		(Load rsVIEW 327)
		(Load rsSOUND 20)
		(super init:)
		(gAddToPics
			add: atpProps
			add: atpDoorNorth
			add: atpDoorSouth
			doit:
		)
		(aSuzi init:)
		(aChair init:)
		(self setScript: RoomScript)
		(= local0 0)
		(if (!= gGNumber 325)
			(= gGEgoX 41)
			(= gGEgoY 156)
			(= gGEgoLoop 0)
		)
		(if (== gGNumber_2 323)
			(proc0_3)
			(gEgo view: 326 setCel: 255)
			(= gGEgoLoop 0)
			(RoomScript changeState: 4)
		else
			(proc0_1)
		)
		(gEgo
			posn: gGEgoX gGEgoY
			loop: gGEgoLoop
			observeBlocks: blockOne blockTwo wallBlockLeft wallBlockRight
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(cond 
				((== global99 1)
					(++ global99)
					(proc255_0 323 0 82 324 5 0)
					(proc255_0 323 1 82 324 5 0)
					(proc255_0 323 2 82 324 5 0)
				)
				((== global99 5)
					(++ global99)
					(proc255_0 323 3 82 324 5 0)
					(proc255_0 323 4 82 324 5 0)
				)
			)
			(global2 newRoom: 320)
		)
	)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0
				(if (not (proc0_22 38)) (= seconds 3))
			)
			(1
				(proc0_19 38)
				(proc255_0 323 41)
				(proc255_0 323 42)
			)
			(2
				(proc0_6)
				(gEgo illegalBits: 0)
				(cond 
					((> (gEgo x?) 119) (gEgo setMotion: MoveTo 119 132 self))
					((< (gEgo x?) 90) (gEgo setMotion: MoveTo 90 132 self))
					(else (gEgo setMotion: MoveTo (gEgo x?) 132 self))
				)
			)
			(3
				(gEgo view: 326 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(= gGNumber_2 1004)
				(User mapKeyToDir: 0 canInput: 1)
				(= cycles (Random 33 66))
			)
			(5
				(gEgo setLoop: (Random 1 4) cel: 0 setCycle: End self)
			)
			(6 (= cycles (Random 11 33)))
			(7
				(gEgo setCycle: Beg self)
				(= state 3)
			)
			(8
				(proc0_3)
				(proc0_6)
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(9
				(proc0_1 2)
				(= gGNumber_2 0)
				(User mapKeyToDir: 1 canInput: 1)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'lie')
				(cond 
					((not (& (gEgo onControl:) $0004)) (proc255_0 323 5))
					((== gGNumber_2 1004) (proc0_8))
					((!= gGNumber_2 0) (proc0_9))
					(else (self changeState: 2))
				)
			)
			(
				(or
					(Said 'nightstand,(get<off),(get<up),(nightstand<up)')
					(Said 'exit/barstool,barstool')
				)
				(cond 
					((== gGNumber_2 0) (proc0_8))
					((!= gGNumber_2 1004) (proc255_0 323 6))
					(else (self changeState: 8))
				)
			)
			((Said 'address/babe')
				(cond 
					((!= gGNumber_2 1004) (proc255_0 323 7))
					((!= local301 0) (proc255_0 323 8))
					((== global99 1)
						(proc255_4 323 9 global171)
						(Format @local0 323 10)
						(SuziScript changeState: 2)
					)
					(else
						(proc255_0 323 11)
						(Format @local0 323 12)
						(SuziScript changeState: 2)
					)
				)
			)
			((or (Said '/deed,land') (Said '//deed,land'))
				(cond 
					((!= gGNumber_2 1004) (proc255_0 323 13))
					((!= local301 0) (proc255_0 323 14))
					((== global99 1)
						(++ global99)
						(gGame changeScore: 30)
						(proc255_0 323 15)
						(proc255_0 323 16)
						(Format @local0 323 17)
						(SuziScript changeState: 2)
					)
					((== global99 2) (Format @local0 323 18) (SuziScript changeState: 2))
					(else
						(proc255_0 323 11)
						(Format @local0 323 12)
						(SuziScript changeState: 2)
					)
				)
			)
			((or (Said '/decree') (Said '//decree'))
				(cond 
					((!= gGNumber_2 1004) (proc255_0 323 19))
					((!= local301 0) (proc255_0 323 14))
					((or (== global99 1) (== global99 2))
						(proc255_0 323 20)
						(Format @local0 323 21)
						(SuziScript changeState: 2)
					)
					((== global99 5)
						(++ global99)
						(gGame changeScore: 40)
						(proc255_0 323 22)
						(Format @local0 323 23)
						(SuziScript changeState: 2)
					)
					((== global99 6)
						(proc255_0 323 24)
						(Format @local0 323 25)
						(SuziScript changeState: 2)
					)
					(else (Format @local0 323 26) (SuziScript changeState: 2))
				)
			)
			((Said '/equipment') (proc255_0 323 27) (proc255_0 323 28 67 -1 144))
			((Said '/call') (proc255_0 323 29))
			((Said '/buffet,calf') (proc255_0 323 30))
			((Said '/barstool') (proc255_0 323 31))
			((Said '/art') (proc255_0 323 32))
			((Said '/door') (proc255_0 323 33))
			((Said '/cup') (proc255_0 323 34))
			(
			(Said '/bookcase,bookcase,bookcase,cabinet,book') (proc255_0 323 35))
			((Said 'look>')
				(cond 
					((Said '/babe,eye')
						(switch local301
							(1 (proc255_0 323 36))
							(3 (proc255_0 323 37))
							(5 (proc255_0 323 38))
							(6 (proc255_0 323 39))
							(else 
								(proc0_6)
								(= gGEgoX (gEgo x?))
								(= gGEgoY (gEgo y?))
								(= gGEgoLoop (gEgo loop?))
								(if (== gGNumber_2 1004) (= gGNumber_2 323))
								(global2 newRoom: 325)
							)
						)
					)
					((Said '[/office,area]') (proc255_0 323 40))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(== (pEvent type?) evMOUSEBUTTON)
						(== gGNumber_2 1004)
						(or (== gCursorNumber 992) (== gCursorNumber 999))
					)
					(self changeState: 8)
				)
				(if
					(and
						(> (pEvent x?) 75)
						(< (pEvent x?) 160)
						(> (pEvent y?) 96)
						(< (pEvent y?) 129)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((not (& (gEgo onControl:) $0004)) (proc255_0 323 5))
								((== gGNumber_2 1004)
									(cond 
										((== gGNumber_2 0) (proc0_8))
										((!= gGNumber_2 1004) (proc255_0 323 6))
										(else (gGame setCursor: 998) (self changeState: 8))
									)
								)
								((!= gGNumber_2 0) (proc0_9))
								(else (gGame setCursor: 998) (self changeState: 2))
							)
						)
						(else 
							(proc0_4)
							(pEvent claimed: 0)
						)
					)
				)
				(if (proc0_26 aSuzi (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(switch local301
								(1 (proc255_0 323 36))
								(3 (proc255_0 323 37))
								(5 (proc255_0 323 38))
								(6 (proc255_0 323 39))
								(else 
									(proc0_6)
									(= gGEgoX (gEgo x?))
									(= gGEgoY (gEgo y?))
									(= gGEgoLoop (gEgo loop?))
									(if (== gGNumber_2 1004)
										(gGame setCursor: 998)
										(= gGNumber_2 323)
									)
									(gGame setCursor: 998)
									(global2 newRoom: 325)
								)
							)
						)
						(994
							(cond 
								((!= gGNumber_2 1004) (proc255_0 323 7))
								((!= local301 0) (proc255_0 323 8))
								((== global99 1)
									(proc255_4 323 9 global171)
									(Format @local0 323 10)
									(SuziScript changeState: 2)
								)
								(else
									(proc255_0 323 11)
									(Format @local0 323 12)
									(SuziScript changeState: 2)
								)
							)
						)
						(996
							(= local302
								(proc255_0
									{&Sobre qu+ quieres hablar?}
									81
									{Tierras}
									1
									81
									{Divorcio}
									2
								)
							)
							(switch local302
								(1
									(cond 
										((!= gGNumber_2 1004) (proc255_0 323 13))
										((!= local301 0) (proc255_0 323 14))
										((== global99 1)
											(++ global99)
											(gGame changeScore: 30)
											(proc255_0 323 15)
											(proc255_0 323 16)
											(Format @local0 323 17)
											(SuziScript changeState: 2)
										)
										((== global99 2) (Format @local0 323 18) (SuziScript changeState: 2))
										(else
											(proc255_0 323 11)
											(Format @local0 323 12)
											(SuziScript changeState: 2)
										)
									)
								)
								(2
									(cond 
										((!= gGNumber_2 1004) (proc255_0 323 19))
										((!= local301 0) (proc255_0 323 14))
										((or (== global99 1) (== global99 2))
											(proc255_0 323 20)
											(Format @local0 323 21)
											(SuziScript changeState: 2)
										)
										((== global99 5)
											(++ global99)
											(gGame changeScore: 40)
											(proc255_0 323 22)
											(Format @local0 323 23)
											(SuziScript changeState: 2)
										)
										((== global99 6)
											(proc255_0 323 24)
											(Format @local0 323 25)
											(SuziScript changeState: 2)
										)
										(else (Format @local0 323 26) (SuziScript changeState: 2))
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

(instance SuziScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 2 1)
		(switch (= state newState)
			(0
				(aSuzi loop: 3 setCel: 0 setCycle: 0)
				(= local301 0)
				(ChairScript changeState: 2)
				(= cycles 0)
				(= seconds (Random 5 10))
			)
			(1
				(cond 
					((== (= local301 (Random 0 7)) 1) (self changeState: 4))
					((== local301 3) (self changeState: 18))
					((== local301 5) (self changeState: 6))
					((== local301 7) (self changeState: 16))
					(else (self changeState: 0))
				)
			)
			(2
				(= local301 2)
				(aSuzi view: 324 loop: 3 setCycle: Fwd)
				(= cycles (Random 11 44))
			)
			(3
				(if (== local0 0)
					(if (== global99 1)
						(Format @local0 323 43)
					else
						(Format @local0 323 44)
					)
				)
				(proc255_0
					@local0
					67
					-1
					10
					80
					{Suzi dice}
					30
					1
					82
					324
					5
					0
				)
				(if (and (== global99 1) (not local300))
					(= local300 1)
					(proc255_0 323 45 67 -1 10 80 {Suzi dice} 30 1 82 324 5 0)
				)
				(= local0 0)
				(= cycles 22)
				(= state -1)
			)
			(4
				(aSuzi view: 324 loop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(self changeState: 0)
				(ChairScript cue:)
			)
			(6
				(= local301 0)
				(= seconds 2)
			)
			(8
				(= local301 5)
				(aSuzi
					view: 327
					loop: 3
					illegalBits: 0
					ignoreActors: 0
					setPri: -1
					loop: -1
					setCycle: Walk
					setMotion: MoveTo 232 125 self
				)
				(ChairScript changeState: 4)
			)
			(9
				(aSuzi setMotion: MoveTo 190 125 self)
			)
			(10
				(aSuzi setMotion: MoveTo 204 204 self)
			)
			(11 (= cycles 15))
			(12
				(= local301 6)
				(aSuzi
					loop: -1
					setCycle: Walk
					setMotion: MoveTo 199 169 self
				)
			)
			(13
				(aSuzi setMotion: MoveTo 190 125 self)
			)
			(14
				(aSuzi ignoreActors: 1 setMotion: MoveTo 232 125 self)
			)
			(15
				(aSuzi setMotion: MoveTo 238 130 self)
			)
			(16
				(aSuzi
					view: 324
					posn: 242 120
					loop: 0
					cel: 0
					setPri: 13
					setCycle: End self
				)
				(ChairScript changeState: 5)
			)
			(17
				(ChairScript changeState: 0)
				(self changeState: 0)
			)
			(18
				(aSuzi view: 324 loop: 1 cel: 0 setCycle: End self)
				(ChairScript changeState: 2)
			)
			(19
				(aSuzi loop: 2 setCycle: Fwd)
				(= cycles (Random 11 33))
			)
			(20
				(aSuzi loop: 1 setCel: 255 setCycle: Beg self)
			)
			(21
				(ChairScript changeState: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance ChairScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 3 4)
		(switch (= state newState)
			(0 (= seconds (Random 5 10)))
			(1
				(if (< local301 4)
					(self cue:)
				else
					(self changeState: 0)
				)
			)
			(2
				(aChair loop: 2 cycleSpeed: 2 setCycle: Fwd)
				(= seconds (Random 2 5))
			)
			(3
				(aChair setCel: 0 setCycle: 0)
				(self changeState: 0)
			)
			(4
				(aChair view: 329 posn: 247 133 loop: 3 stopUpd:)
				(= cycles (= seconds 0))
			)
			(5
				(aChair
					view: 329
					loop: 0
					posn: 247 133
					cel: 0
					setCycle: End
				)
			)
		)
	)
)

(instance atpProps of PV
	(properties
		y 132
		x 240
		view 329
		loop 4
		priority 10
		signal $4000
	)
)

(instance aChair of Prop
	(properties
		y 133
		x 247
		view 329
		loop 2
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 9)
	)
)

(instance aSuzi of Act
	(properties
		y 120
		x 242
		view 324
		loop 1
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			illegalBits: 0
			setScript: SuziScript
			setPri: 11
			stopUpd:
		)
	)
)

(instance blockOne of Blk
	(properties
		top 199
		left 74
		bottom 333
		right 231
	)
)

(instance blockTwo of Blk
	(properties
		top 217
		left -20
		bottom 333
		right 333
	)
)

(instance wallBlockLeft of Blk
	(properties
		top 175
		left -20
		bottom 333
		right -3
	)
)

(instance wallBlockRight of Blk
	(properties
		left 325
		bottom 333
		right 340
	)
)

(instance aPhone of Act
	(properties
		y -4
		x 152
		view 323
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			loop: 4
			setPri: 5
			setStep: 1 1
		)
	)
)

(instance atpDoorSouth of PV
	(properties
		y 103
		x 20
		view 323
		cel 3
		priority 13
		signal $4000
	)
)

(instance atpDoorNorth of PV
	(properties
		y 95
		x 41
		view 323
		loop 1
		cel 3
		priority 11
		signal $4000
	)
)
