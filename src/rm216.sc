;;; Sierra Script 1.0 - (do not remove this comment)
(script# 216)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm216 0
)
(synonyms
	(box lid)
)

(local
	local0
	local1
	[local2 222]
)
(procedure (localproc_0016 &tmp temp0)
	(proc255_0
		@local2
		67
		10
		15
		80
		{Kalalau dice...}
		70
		160
		25
		(= temp0 (proc0_25 @local2))
		88
	)
	(return (+ 3 temp0))
)

(procedure (localproc_0049 &tmp temp0)
	(proc255_0
		@local2
		67
		10
		123
		80
		{Dices...}
		70
		160
		25
		(= temp0 (proc0_25 @local2))
		88
	)
	(return (+ 3 temp0))
)

(instance rm216 of Rm
	(properties
		picture 216
		east 210
	)
	
	(method (init)
		(if (not (proc0_22 20)) (aKandBB init:))
		(Load rsVIEW 217)
		(Load rsSOUND 217)
		(Load rsSOUND 218)
		(super init:)
		(aMailBox init: stopUpd:)
		(self setScript: RoomScript)
		(if (and (proc0_22 20) (not (proc0_22 27)))
			(Load rsVIEW 219)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(proc0_1)
		(gEgo
			loop: 1
			posn: 318 166
			observeBlocks: blockFence1 blockFence2
			init:
		)
		(if (gCast contains: aKandBB)
			(gTheSoundFX number: 216 loop: -1 play:)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(User canInput: 0 mapKeyToDir: 0)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc0_22 20)) (= cycles 40))
			)
			(1
				(proc0_3)
				(gEgo loop: 3)
				(Format @local2 216 32)
				(= seconds (localproc_0049))
				(= cycles 0)
			)
			(2
				(Format @local2 216 33)
				(= seconds (localproc_0016))
			)
			(3
				(proc255_0 216 34 67 -1 144 88 25 11)
				(= seconds 14)
			)
			(4
				(Format @local2 216 35)
				(= seconds (localproc_0049))
			)
			(5
				(Format @local2 216 36)
				(= seconds (localproc_0016))
			)
			(6
				(Format @local2 216 37)
				(= seconds (localproc_0049))
			)
			(7
				(Format @local2 216 38)
				(= seconds (localproc_0016))
			)
			(8
				(Format @local2 216 39)
				(= seconds (localproc_0049))
			)
			(9
				(Format @local2 216 40)
				(= seconds (localproc_0016))
			)
			(10
				(proc0_19 20)
				(proc255_0
					(Format
						@local2
						216
						41
						(if (>= global88 3) { lesbiana} else {})
					)
					88
					25
					28
				)
				(= seconds 31)
			)
			(11
				(proc0_4)
				(proc0_5)
				(= seconds 0)
			)
			(12
				(proc0_3)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 118 120 self
				)
			)
			(13
				(gEgo loop: 3)
				(= seconds 2)
			)
			(14
				(gEgo
					view: 217
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(gTheSoundFX number: 217 loop: 1 play:)
			)
			(15
				(aMailBox setCel: (if (proc0_23 1) 1 else 2) stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(16
				(proc0_1 3)
				(= local1 1)
				(if (gCast contains: aKandBB)
					(gTheSoundFX number: 216 loop: -1 play:)
				)
			)
			(18
				(proc0_3)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 118 120 self
				)
			)
			(19
				(gEgo loop: 3)
				(= seconds 2)
			)
			(20
				(gEgo
					view: 217
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(21
				(aMailBox setCel: 0 stopUpd:)
				(gEgo setCycle: Beg self)
				(gTheSoundFX number: 218 loop: 1 play:)
			)
			(22
				(proc0_1 3)
				(= local1 0)
				(if (gCast contains: aKandBB)
					(gTheSoundFX number: 216 loop: -1 play:)
				)
			)
			(23
				(proc0_3)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 118 120 self
				)
			)
			(24
				(gEgo loop: 3)
				(= seconds 2)
			)
			(25
				(gEgo
					cycleSpeed: 1
					view: 217
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(26
				(aMailBox setCel: 2 stopUpd:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(27 (= seconds 2))
			(28
				(proc255_0 216 42 67 10 5 70 290)
				(= cycles 22)
			)
			(29
				(gEgo view: 217 setLoop: 2 cel: 0 setCycle: End self)
			)
			(30 (= cycles 20))
			(31
				(proc255_0 216 43 67 10 5 70 290)
				(gEgo setCycle: Beg self)
			)
			(32
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(33
				(gEgo get: 1)
				(gGame changeScore: 20)
				(proc255_0 216 44 82 217 3 0 67 -1 10)
				(= seconds 3)
			)
			(34 (proc0_1 3))
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (super handleEvent: pEvent))
				(not (pEvent claimed?))
				gTheNewDialog
				(or
					(and
						(== (pEvent message?) KEY_RETURN)
						(== (pEvent type?) evKEYBOARD)
					)
					(== (pEvent type?) evMOUSEBUTTON)
				)
			)
			(pEvent claimed: 1)
			(proc0_5)
			(self cue:)
		)
		(if (pEvent claimed?) (return (pEvent claimed?)))
		(return
			(cond 
				((Said 'climb,jump/wall') (if global108 (proc255_0 216 0) else (proc255_0 216 1)))
				((Said '/club,club') (if global108 (proc255_0 216 2) else (proc255_0 216 3)))
				((Said 'get/box') (proc255_0 216 4))
				((Said 'open/door') (proc255_0 216 5))
				((Said 'pick,break/bolt,door,fence') (proc255_0 216 6))
				((Said 'climb/door') (if global108 (proc255_0 216 7) else (proc255_0 216 8)))
				((Said 'unbolt/door') (proc255_0 216 9))
				((Said 'look<in/box')
					(cond 
						(global108 (proc255_0 216 10))
						((!= gGNumber_2 0) (proc0_9))
						((not (& (gEgo onControl:) $0002)) (proc0_10))
						((not local1) (proc255_0 216 11))
						((proc0_23 1) (proc255_0 216 12))
						(else (proc255_0 216 13) (proc255_0 216 14))
					)
				)
				((Said 'open/box')
					(cond 
						(global108 (proc255_0 216 10))
						((!= gGNumber_2 0) (proc0_9))
						((not (& (gEgo onControl:) $0002)) (proc0_10))
						(local1 (proc0_7))
						(else (self changeState: 12))
					)
				)
				((Said 'close/box')
					(cond 
						((!= gGNumber_2 0) (proc0_9))
						((not (& (gEgo onControl:) $0002)) (proc0_10))
						((not local1) (proc0_7))
						(else (self changeState: 18))
					)
				)
				((Said 'get/card,letter,letter,envelope')
					(cond 
						((!= gGNumber_2 0) (proc0_9))
						((not (proc0_23 1)) (proc255_0 216 15))
						((not (& (gEgo onControl:) $0002)) (proc0_10))
						((not local1) (proc255_0 216 16))
						(else (self changeState: 23))
					)
				)
				((Said 'tickle/finial') (proc255_0 216 17))
				((Said '/wall,fence>')
					(cond 
						((Said 'climb/') (proc255_0 216 18))
						((Said 'look/')
							(if global108
								(proc255_0 216 19)
							else
								(proc255_0 216 20)
							)
						)
						(else (pEvent claimed: 1) (proc255_0 216 21))
					)
				)
				((Said 'look>')
					(cond 
						(
						(and (proc0_23 1) (Said '/letter,letter,envelope,card')) (proc255_0 216 22))
						((Said '/box')
							(if (& (gEgo onControl:) $0002)
								(proc255_0 216 23)
							else
								(proc255_0 216 24)
							)
						)
						((Said '/door') (proc255_0 216 25))
						((Said '/finial') (proc255_0 216 26) (proc255_0 216 27 67 -1 144))
						((Said '/building')
							(if global108
								(proc255_0 216 28)
							else
								(proc255_0 216 29)
							)
						)
						((Said '[/area]')
							(if global108
								(proc255_0 216 28)
							else
								(proc255_0 216 30)
								(proc255_0 216 31 67 -1 144)
							)
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
							(> (pEvent x?) 308)
							(> (pEvent y?) 143)
							(< (pEvent y?) 188)
							(== gCursorNumber 999)
						)
						(gEgo setMotion: MoveTo 321 168)
						(pEvent claimed: 1)
					)
					(if (proc0_26 aMailBox (pEvent x?) (pEvent y?))
						(pEvent claimed: 1)
						(switch gCursorNumber
							(995
								(cond 
									(global108 (proc255_0 216 10))
									((!= gGNumber_2 0) (proc0_9))
									((not (& (gEgo onControl:) $0002)) (gEgo setMotion: MoveTo 130 126) (self changeState: 12))
									(local1 (proc255_0 {Est* abierto}))
									(else (self changeState: 12))
								)
							)
							(998
								(if (proc0_23 1)
									(cond 
										((!= gGNumber_2 0) (proc0_9))
										((not (proc0_23 1)) (proc255_0 216 15))
										((not (& (gEgo onControl:) $0002)) (proc0_10))
										((not local1) (proc255_0 216 16))
										(else (self changeState: 23))
									)
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 59)
							(< (pEvent x?) 93)
							(> (pEvent y?) 75)
							(< (pEvent y?) 102)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998 (proc255_0 216 25))
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 175)
							(< (pEvent x?) 319)
							(> (pEvent y?) 69)
							(< (pEvent y?) 143)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(if global108
									(proc255_0 216 28)
								else
									(proc255_0 216 29)
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
				)
				(else 0)
			)
		)
	)
)

(instance aKandBB of Prop
	(properties
		view 218
	)
	
	(method (init)
		(super init:)
		(self posn: 246 42 setScript: KandBBScript)
	)
)

(instance KandBBScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(aKandBB loop: 0 setCycle: Fwd)
				(= cycles (Random 20 40))
			)
			(2
				(aKandBB setCel: 3)
				(= cycles (Random 20 40))
			)
			(3
				(aKandBB loop: 1 setCycle: Fwd)
				(= cycles (Random 20 40))
			)
			(4
				(aKandBB setCel: 3)
				(= cycles (Random 20 40))
			)
			(5
				(if (== 1 (Random 1 4))
					(aKandBB loop: 2 setCycle: End)
					(= cycles (Random 80 140))
				else
					(self changeState: 1)
				)
			)
			(6
				(aKandBB setCycle: Beg)
				(self changeState: 1)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(if (Said 'address/babe,babe,exwife')
			(switch (++ local0)
				(1
					(proc255_0 216 45)
					(proc255_0 216 46)
				)
				(2
					(proc255_0 216 47)
					(proc255_0 216 46)
				)
				(3
					(proc255_0 216 48)
					(proc255_0 216 49)
					(proc255_0 216 50)
				)
				(else 
					(proc255_0 216 51)
					(proc255_0 216 52)
					(proc255_0 216 53)
				)
			)
		)
		(if (Said '/club,club') (proc255_0 216 54))
		(if (Said 'look/babe,babe,exwife')
			(if (> global88 3)
				(proc255_0 216 55)
			else
				(proc255_0 216 56)
			)
		)
	)
)

(instance blockFence2 of Blk
	(properties
		top 190
		bottom 333
		right 190
	)
)

(instance blockFence1 of Blk
	(properties
		top 200
		bottom 333
		right 333
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 240
		view 219
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
		view 219
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
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit2 setLoop: 2 setCycle: End)
				(= cycles 22)
			)
			(5
				(proc0_19 27)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(6
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

(instance aMailBox of Prop
	(properties
		y 107
		x 134
		view 216
		signal $0001
	)
)
