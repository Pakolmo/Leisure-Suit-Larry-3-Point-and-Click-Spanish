;;; Sierra Script 1.0 - (do not remove this comment)
(script# 235)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Obj)

(public
	rm235 0
)

(instance rm235 of Rm
	(properties
		picture 235
		west 230
	)
	
	(method (init)
		(if (proc0_23 11) (Load rsVIEW 236))
		(super init:)
		(self setRegions: 41 setScript: RoomScript)
		(gEgo posn: 43 124 loop: 0 init:)
		(proc0_1)
		(User canInput: 0 mapKeyToDir: 0)
		(if gGNumber_2 (gEgo observeControl: 2))
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (& (gEgo onControl:) $0002) (== gGNumber_2 0))
			(proc0_13 41 2 300)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (if (& (gEgo onControl:) $0008) 99 else 235) 96 self
				)
			)
			(2
				(gEgo
					get: 11
					view: 236
					loop: (if (< (gEgo x?) 160) 1 else 0)
					cel: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= cycles 44)
			)
			(3
				(cond 
					((and (== global74 1) (== global73 0)) (proc255_0 235 12))
					((proc0_22 54) (proc255_0 235 13))
					(else (proc0_19 54) (gGame changeScore: 25) (proc255_0 235 10))
				)
				(proc0_1)
				(proc0_16 1 10 0)
				((Inv at: 11) view: 11)
				(Format ((Inv at: 11) name?) {Orqu|deas})
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'look<up') (proc255_0 235 0))
			((Said 'look<down') (proc255_0 235 1) (proc255_0 235 2 67 -1 144))
			((Said 'look>')
				(cond 
					((Said '[/area]') (proc255_0 235 3))
					((Said '/carpet,carpet') (proc255_0 235 4))
					((Said '/ceiling,air') (proc255_0 235 0))
					((Said '/camp,beach,bay,water') (proc255_0 235 5) (proc255_0 235 2 67 -1 144))
					((Said '/bush') (proc255_0 235 6))
					((Said '/flower,boulder,wall') (proc255_0 235 7))
				)
			)
			((Said 'get/bush') (proc255_0 235 8))
			((Said 'get,pick/flower')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					(global108 (proc255_0 235 9))
					(
						(and
							(not (& (gEgo onControl:) $0004))
							(not (& (gEgo onControl:) $0008))
						)
					)
					((and (== global74 1) (== global73 0)) (self changeState: 1))
					((not (proc0_23 11)) (proc255_0 235 11))
					(else (self changeState: 1))
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
					(> (pEvent x?) 35)
					(< (pEvent x?) 61)
					(> (pEvent y?) 80)
					(< (pEvent y?) 137)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 45 125 self)
						(gEgo setMotion: MoveTo -3 125)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 76)
					(< (pEvent x?) 100)
					(> (pEvent y?) 26)
					(< (pEvent y?) 90)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							(global108 (proc255_0 235 9))
							(
								(and
									(not (& (gEgo onControl:) $0004))
									(not (& (gEgo onControl:) $0008))
								)
							)
							((and (== global74 1) (== global73 0)) (self changeState: 1))
							((not (proc0_23 11)) (proc255_0 235 11))
							(else (self changeState: 1))
						)
					)
					(998 (proc255_0 235 7))
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 215)
					(< (pEvent x?) 297)
					(> (pEvent y?) 26)
					(< (pEvent y?) 125)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							(global108 (proc255_0 235 9))
							(
								(and
									(not (& (gEgo onControl:) $0004))
									(not (& (gEgo onControl:) $0008))
								)
							)
							((and (== global74 1) (== global73 0)) (self changeState: 1))
							((not (proc0_23 11)) (proc255_0 235 11))
							(else (self changeState: 1))
						)
					)
					(998 (proc255_0 235 3))
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 110)
					(< (pEvent x?) 205)
					(> (pEvent y?) 20)
					(< (pEvent y?) 188)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(proc255_0 235 5)
						(proc255_0 235 2 67 -1 144)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)
