;;; Sierra Script 1.0 - (do not remove this comment)
(script# 410)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm410 0
)

(local
	local0
)
(instance rm410 of Rm
	(properties
		picture 410
		south 400
	)
	
	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(proc0_1)
		(cond 
			((== gGNumber 415) (gEgo posn: 59 45))
			((== gGNumber 416) (gEgo posn: 263 45))
			(else (gEgo posn: 159 188))
		)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			((& (gEgo onControl: 1) $0002) (global2 newRoom: 415))
			((& (gEgo onControl: 1) $0004) (global2 newRoom: 416))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(cond 
				((Said '/art,body,naked,babe,art') (proc255_0 410 0))
				((Said '/column') (proc255_0 410 1))
				((Said '/rail') (proc255_0 410 2))
				((Said '/stair') (proc255_0 410 3))
				((Said '/curtain') (proc255_0 410 4))
				((Said '[/area]') (proc255_0 410 5))
			)
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 1)
					(< (pEvent x?) 310)
					(> (pEvent y?) 168)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 160 195)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 1)
					(< (pEvent x?) 319)
					(> (pEvent y?) 21)
					(< (pEvent y?) 169)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(switch (Random 0 5)
							(0 (proc255_0 410 0))
							(1 (proc255_0 410 1))
							(2 (proc255_0 410 2))
							(3 (proc255_0 410 3))
							(4 (proc255_0 410 4))
							(5 (proc255_0 410 5))
						)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)
