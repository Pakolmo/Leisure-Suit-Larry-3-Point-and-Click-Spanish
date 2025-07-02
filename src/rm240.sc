;;; Sierra Script 1.0 - (do not remove this comment)
(script# 240)
(include sci.sh)
(use Main)
(use AutoDoor)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm240 0
)

(local
	local0
)
(instance rm240 of Rm
	(properties
		picture 240
		horizon 66
		north 245
		east 245
		west 230
	)
	
	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(aDoor
			locked: (if (!= gGNumber_2 0) else global108)
			init:
		)
		(cond 
			((== gGNumber 230) (gEgo x: 1))
			((== gGNumber 340) (gEgo posn: 53 77 loop: 2))
			(else (gEgo posn: 292 73))
		)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl:) $0002)
				(or global108 (!= gGNumber_2 0))
			)
			(if (not local0)
				(= local0 1)
				(gEgo
					posn: (gEgo xLast?) (gEgo yLast?)
					setMotion: 0
					observeControl: 2
				)
				(if global108 (proc255_0 240 0) else (proc255_0 240 1))
				(Animate (gCast elements?) 0)
			)
		else
			(= local0 0)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(cond 
				((Said '/club,comedy,building') (proc255_0 240 2))
				((Said '/door') (if global108 (proc255_0 240 3) else (proc255_0 240 4)))
				((Said '[/area]')
					(proc255_0 240 5)
					(if global108 (proc255_0 240 6) else (proc255_0 240 7))
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
					(> (pEvent x?) 15)
					(< (pEvent x?) 257)
					(> (pEvent y?) 84)
					(< (pEvent y?) 175)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(proc255_0 240 5)
						(if global108 (proc255_0 240 6) else (proc255_0 240 7))
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if (proc0_26 aDoor (pEvent x?) (pEvent y?))
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(if global108 (proc255_0 240 3) else (proc255_0 240 4))
					)
					(995
						(gEgo setMotion: MoveTo 50 50)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 1)
					(< (pEvent x?) 11)
					(> (pEvent y?) 97)
					(< (pEvent y?) 129)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -5 120)
					)
				)
			)
		)
	)
)

(instance aDoor of AutoDoor
	(properties
		y 66
		x 53
		view 240
		entranceTo 340
	)
)
