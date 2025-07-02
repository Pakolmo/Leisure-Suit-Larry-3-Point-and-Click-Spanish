;;; Sierra Script 1.0 - (do not remove this comment)
(script# 523)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm523 0
)

(instance rm523 of Rm
	(properties
		picture 523
		west 520
	)
	
	(method (init)
		(super init:)
		(self setRegions: 41 setScript: RoomScript)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (& (gEgo onControl:) $0002) (== gGNumber_2 0))
			(proc0_13 41 2 188)
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'use,attach/bra')
				(cond 
					((not (gEgo has: 16)) (proc0_12))
					((!= gGNumber_2 0) (proc0_9))
					(else (proc255_0 523 0))
				)
			)
			((Said 'use,attach/hose')
				(if (not (gEgo has: 15))
					(proc255_0 523 1)
				else
					(proc255_0 523 2)
				)
			)
			((Said 'look>')
				(cond 
					((Said '/boulder') (proc255_0 523 3))
					((Said '[/area]') (proc255_0 523 4))
				)
			)
			((Said '(up<climb),climb/boulder,arch') (proc255_0 523 5))
			(
				(or
					(Said '(climb,go)<(down,above)')
					(Said 'decrease/i')
				)
				(proc255_0 523 6)
			)
			((Said 'climb') (proc255_0 523 7) (proc255_0 523 8 67 -1 144))
			((Said 'drag,grasp,get/bush,hemp') (proc255_0 523 9))
			((Said 'get,use/palm') (proc255_0 523 10))
			((Said '/bush') (proc255_0 523 11))
			((Said '/arch') (proc255_0 523 12))
			((Said '/flower') (proc255_0 523 13))
			((Said 'jump') (proc255_0 523 14))
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 8)
						(> (pEvent y?) 103)
						(< (pEvent y?) 184)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo -4 160)
						)
						(else  (pEvent claimed: 0))
					)
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
							(switch (Random 1 2)
								(1 (proc255_0 523 4))
								(2 (proc255_0 523 3))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)
