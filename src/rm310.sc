;;; Sierra Script 1.0 - (do not remove this comment)
(script# 310)
(include sci.sh)
(use Main)
(use AutoDoor)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm310 0
)

(local
	[local0 312]
)
(instance rm310 of Rm
	(properties
		picture 310
		south 220
	)
	
	(method (init)
		(super init:)
		(gAddToPics add: atpSign doit:)
		(if (< global99 8)
			(gAddToPics add: atpRoger doit:)
		else
			(gAddToPics add: atpNoRoger doit:)
		)
		(aDoor init:)
		(self setScript: RoomScript)
		(if (== gGNumber 320)
			(gEgo posn: 220 88)
		else
			(gEgo posn: 84 188)
		)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return (pEvent claimed?)))
		(return
			(cond 
				((Said 'look<down') (proc255_0 310 0))
				(
					(and
						(gEgo has: 2)
						(!= ((gInv at: 2) view?) 21)
						(Said 'sharpen/ginsu')
					)
					(proc255_0 310 1)
				)
				((Said 'look>')
					(cond 
						((Said '/camp,beach,bay,water') (proc255_0 310 2))
						((Said '/awning') (proc255_0 310 3))
						((Said '/bush') (proc255_0 310 4))
						((Said '/flower,boulder,wall') (proc255_0 310 5))
						((Said '[/area]') (proc255_0 310 6) (proc255_0 310 7 67 -1 144))
					)
				)
				((Said 'get/bush') (proc255_0 310 8))
				((Said 'get,pick/flower') (proc255_0 310 9))
				(
					(and
						(== (pEvent type?) evMOUSEBUTTON)
						(not (& (pEvent modifiers?) emSHIFT))
					)
					(if
						(and
							(> (pEvent x?) 37)
							(< (pEvent x?) 129)
							(> (pEvent y?) 171)
							(< (pEvent y?) 189)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(999
								(gEgo setMotion: MoveTo 75 190)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 1)
							(< (pEvent x?) 44)
							(> (pEvent y?) 41)
							(< (pEvent y?) 132)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(2 (proc255_0 310 1))
							(995 (proc255_0 310 9))
							(998 (proc255_0 310 5))
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 68)
							(< (pEvent x?) 316)
							(> (pEvent y?) 38)
							(< (pEvent y?) 169)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(proc255_0 310 6)
								(proc255_0 310 7 67 -1 144)
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

(instance atpSign of PV
	(properties
		y 189
		x 192
		view 310
		priority 14
	)
)

(instance aDoor of AutoDoor
	(properties
		y 87
		x 220
		view 310
		loop 1
		cycleSpeed 2
		entranceTo 320
	)
	
	(method (init)
		(super init:)
		(self setPri: 4)
	)
)

(instance atpRoger of PV
	(properties
		y 45
		x 219
		view 310
		loop 2
		priority 2
	)
)

(instance atpNoRoger of PV
	(properties
		y 51
		x 219
		view 310
		loop 2
		cel 1
		priority 2
	)
)
