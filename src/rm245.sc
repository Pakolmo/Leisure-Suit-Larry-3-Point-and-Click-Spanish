;;; Sierra Script 1.0 - (do not remove this comment)
(script# 245)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm245 0
)

(local
	local0
)
(instance rm245 of Rm
	(properties
		picture 245
		west 240
	)
	
	(method (init)
		(super init:)
		(self setRegions: 41 setScript: RoomScript)
		(if (== gGNumber 500)
			(gEgo posn: 126 73 loop: 2)
		else
			(gEgo posn: 5 172 loop: 0)
		)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
		(if gGNumber_2 (gEgo observeControl: 4 8 16))
	)
	
	(method (newRoom newRoomNumber)
		(proc0_5)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(if (not global108)
			(gEgo observeControl: 16384)
			(if (& (gEgo onControl:) $0020)
				(if (not local0) (= local0 1) (proc255_0 245 0))
			else
				(= local0 0)
			)
		)
		(if (== gGNumber_2 0)
			(cond 
				((& (gEgo onControl:) $0002)
					(if (not (gEgo has: 13))
						(proc255_0 {Retrocede, &tienes agua para el viaje?})
					)
					(if (not (gEgo has: 15))
						(proc255_0 {Retrocede, vas a necesitar toda tu ropa.})
					)
					(if (not (gEgo has: 16))
						(proc255_0 {Retrocede, olvidaste ponerte tu sujetador.})
					)
					(if (not (gEgo has: 18))
						(proc255_0 {Retrocede, necesitar*s algo m*gico...})
					)
					(global2 newRoom: 500)
				)
				((& (gEgo onControl:) $0010) (proc0_13 41 9 300))
				((& (gEgo onControl:) $0004) (proc0_13 41 0 300))
				(
					(or
						(== 2 (gEgo edgeHit?))
						(& (gEgo onControl:) $0008)
					)
					(gEgo x: (+ (gEgo x?) 8))
					(proc0_13 41 8 300)
				)
			)
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(cond 
				((Said '/ball,boulder,boob') (proc255_0 245 1))
				((Said '/bamboo') (proc255_0 245 2))
				((Said '[/area]') (proc255_0 245 3))
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
					(< (pEvent x?) 16)
					(> (pEvent y?) 157)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -2 177)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 128)
					(< (pEvent x?) 207)
					(> (pEvent y?) 21)
					(< (pEvent y?) 65)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998 (proc255_0 245 2))
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 10)
					(< (pEvent x?) 319)
					(> (pEvent y?) 69)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998 (proc255_0 245 3))
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 208)
					(< (pEvent x?) 256)
					(> (pEvent y?) 28)
					(< (pEvent y?) 69)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998 (proc255_0 245 1))
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)
