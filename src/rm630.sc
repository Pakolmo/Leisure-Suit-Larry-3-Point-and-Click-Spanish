;;; Sierra Script 1.0 - (do not remove this comment)
(script# 630)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Wander)
(use Follow)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm630 0
)
(synonyms
	(cable cable)
)

(instance rm630 of Rm
	(properties
		picture 630
		horizon 1
		east 640
	)
	
	(method (init)
		(Load rsVIEW 720)
		(Load rsVIEW 631)
		(Load rsVIEW global66)
		(Load rsSOUND 630)
		(Load rsSOUND 4)
		(Load rsSOUND 5)
		(Load rsSOUND 631)
		(Load rsSOUND 699)
		(Load rsSCRIPT 969)
		(Load rsSCRIPT 970)
		(super init:)
		(aGeneratorBottom init:)
		(aGeneratorTop init:)
		(aSwitch init:)
		(aLarry init:)
		(proc0_1)
		(gEgo
			illegalBits: 0
			view: 632
			setLoop: 0
			setPri: 13
			cel: 0
			posn: 7 183
			init:
			baseSetter: SQ3Base
		)
		(self setScript: RoomScript)
		(= gGNumber_2 630)
		(gTheMusic number: 630 loop: global72 play:)
	)
	
	(method (newRoom newRoomNumber)
		(DisposeScript 970)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== gGNumber_2 630)
			(aLarry
				brLeft: (- (aLarry x?) 4)
				brRight: (+ (aLarry x?) 4)
			)
		)
	)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0
				(proc0_3)
				(gEgo setMotion: MoveTo 19 171 setCycle: End self)
			)
			(1
				(gEgo
					posn: 35 149
					setLoop: 1
					cel: 1
					setCycle: Fwd
					cycleSpeed: 4
					moveSpeed: 1
					setStep: 1 1
					setMotion: MoveTo 72 138 self
				)
			)
			(2
				(proc255_4 630 10 global170)
				(gEgo
					observeControl: 8192
					baseSetter: SQ3Base
					setMotion: MoveTo 187 99 self
				)
				(aLarry setMotion: MoveTo 6 185 self)
			)
			(3
				(aLarry
					view: 631
					setLoop: 0
					cel: 0
					setMotion: MoveTo 18 173
					setCycle: End self
				)
			)
			(4
				(proc255_0 630 11)
				(aLarry
					posn: 31 150
					setLoop: 1
					cel: 1
					setCycle: Fwd
					cycleSpeed: 4
					moveSpeed: 1
					setStep: 1 1
					setMotion: MoveTo 153 41 self
				)
				(proc0_4)
				(gEgo
					illegalBits: 0
					observeControl: -32768 8192
					baseSetter: SQ3Base
				)
			)
			(5
				(aLarry observeControl: -32768 16384 setMotion: Wander 22)
			)
			(6
				(proc0_6)
				(proc0_3)
				(gGame changeScore: 40)
				(aSwitch setCycle: End self)
				(aLarry setMotion: MoveTo 148 (aLarry y?))
			)
			(7
				(aSwitch stopUpd:)
				(aGeneratorTop setCel: 0 stopUpd:)
				(if (== global72 -1)
					(gTheMusic number: 631 loop: 1 play: self)
				else
					(= cycles 22)
				)
			)
			(8
				(proc255_0 630 12)
				(if (== global72 -1) (= seconds 2) else (= cycles 22))
			)
			(9
				(= gGNumber_2 2)
				(proc255_0 630 13)
				(gTheMusic number: 4 loop: 1 play:)
				(gEgo
					baseSetter: 0
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 3 4
					setMotion: MoveTo (gEgo x?) 152 self
				)
				(aLarry
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 3 4
					setMotion: MoveTo (aLarry x?) 152 self
				)
			)
			(10
				(gEgo posn: (gEgo x?) 181 loop: 2 cel: 0 setCycle: End)
			)
			(11
				(aLarry
					posn: (aLarry x?) 181
					loop: 2
					cel: 0
					setCycle: End
				)
				(= seconds 3)
			)
			(12
				(gEgo cycleSpeed: 1 loop: 3 cel: 0 setCycle: End)
				(aLarry cycleSpeed: 1 loop: 3 cel: 0 setCycle: End self)
			)
			(13
				(aLarry loop: 4 setCycle: Fwd)
				(gEgo loop: 4 setCycle: Fwd)
				(gTheMusic number: 5 loop: 1 play: self)
			)
			(14
				(= gGNumber_2 0)
				(proc0_1 3)
				(proc0_2 aLarry 3 720)
				(aLarry setMotion: Follow gEgo 28)
				(gTheMusic number: 699 loop: global72 play:)
				(proc255_0 630 14)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
			(Said 'cable,attach,(on<drag)/cable,equipment,handle') (if (== gGNumber_2 0) (proc0_7) else (proc255_0 630 0)))
			(
				(Said
					'disconnect,drain,(off<drag),cease,drag/cable,equipment,handle'
				)
				(cond 
					((!= gGNumber_2 630) (proc0_9))
					((not (gEgo inRect: 190 126 261 154)) (proc0_10))
					((or (< (gEgo cel?) 6) (> (gEgo cel?) 9)) (proc255_0 630 1))
					(else (RoomScript changeState: 6))
				)
			)
			((Said 'get/cable,cable') (proc255_0 630 2))
			((Said 'look>')
				(cond 
					((Said '/cable,cable,cable')
						(if (== gGNumber_2 630)
							(proc255_0 630 3)
						else
							(proc255_0 630 4)
						)
					)
					((Said '/larry') (proc255_0 630 5))
					((Said '/equipment,equipment')
						(if (== gGNumber_2 630)
							(proc255_0 630 6)
						else
							(proc255_0 630 7)
						)
					)
					((Said '[/area]')
						(proc255_0 630 8)
						(if (== gGNumber_2 630) (proc255_0 630 9))
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
						(> (pEvent x?) 1)
						(< (pEvent x?) 319)
						(> (pEvent y?) 21)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 630 8)
							(if (== gGNumber_2 630) (proc255_0 630 9))
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 309)
						(< (pEvent x?) 319)
						(> (pEvent y?) 154)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 321 175)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
				(proc0_26 aGeneratorBottom (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(if (== gGNumber_2 630)
								(proc255_0 630 3)
							else
								(proc255_0 630 4)
							)
						)
						(995
							(cond 
								((!= gGNumber_2 630) (proc0_9))
								((not (gEgo inRect: 190 126 261 154)) (proc0_10))
								((or (< (gEgo cel?) 6) (> (gEgo cel?) 9)) (proc255_0 630 1))
								(else (RoomScript changeState: 6))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aLarry (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 630 5))
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aGeneratorBottom of View
	(properties
		y 149
		x 227
		view 630
	)
	
	(method (init)
		(super init:)
		(self setPri: 5 ignoreActors: stopUpd:)
	)
)

(instance aGeneratorTop of Prop
	(properties
		y 133
		x 235
		view 630
		loop 2
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setPri: 6 setCycle: Fwd)
	)
)

(instance aSwitch of Prop
	(properties
		y 153
		x 213
		view 630
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 7 ignoreActors: stopUpd:)
	)
)

(instance aLarry of Act
	(properties
		y 184
		x -28
		view 720
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd setPri: 5 ignoreActors:)
	)
)

(instance SQ3Base of Code
	(properties)
	
	(method (doit &tmp temp0)
		(gEgo brBottom: (+ (gEgo y?) 1))
		(gEgo brTop: (- (gEgo brBottom?) (gEgo yStep?)))
		(gEgo brLeft: (- (gEgo x?) 18))
		(gEgo brRight: (+ (gEgo x?) 18))
	)
)
