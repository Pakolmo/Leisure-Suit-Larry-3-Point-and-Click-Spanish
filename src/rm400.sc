;;; Sierra Script 1.0 - (do not remove this comment)
(script# 400)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm400 0
)

(instance rm400 of Rm
	(properties
		picture 400
		horizon 83
		north 410
		east 460
		south 250
		west 250
	)
	
	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(proc0_1)
		(switch gGNumber
			(460 (gEgo posn: 318 162))
			(410
				(if (< (gEgo x?) 111) (gEgo x: 111))
				(if (> (gEgo x?) 210) (gEgo x: 210))
			)
			(else  (gEgo posn: 159 188))
		)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(cond 
				((Said '/burn') (proc255_4 400 0 global82))
				((Said '[/area]') (proc255_0 400 1))
			)
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 10)
					(< (pEvent x?) 292)
					(> (pEvent y?) 180)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 143 192)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 312)
					(< (pEvent x?) 319)
					(> (pEvent y?) 136)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 321 159)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 31)
					(< (pEvent x?) 272)
					(> (pEvent y?) 21)
					(< (pEvent y?) 179)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998 (proc255_0 400 1))
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)
