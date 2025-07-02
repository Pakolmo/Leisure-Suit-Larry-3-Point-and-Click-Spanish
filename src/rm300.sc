;;; Sierra Script 1.0 - (do not remove this comment)
(script# 300)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm300 0
)

(local
	local0
	[local1 301]
)
(instance rm300 of Rm
	(properties
		picture 300
		east 220
	)
	
	(method (init)
		(super init:)
		(gAddToPics add: atpSign doit:)
		(aSpout init:)
		(self setScript: RoomScript)
		(proc0_1)
		(if (== gGNumber 360)
			(gEgo posn: 155 190 setPri: 4 setLoop: 2)
			(RoomScript changeState: 1)
			(if
			(and global118 (not (proc0_22 10)) (not (proc0_22 8)))
				(proc0_19 53)
			)
		else
			(gEgo posn: 318 184 loop: 1)
		)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $4000)
			(cond 
				((== gGNumber_2 0)
					(if (not (gEgo has: 8)) (proc255_0 370 55) else 0)
					(if (not (gEgo has: 5)) (proc255_0 360 7) else 0)
					(= gGNumber_2 300)
					(self changeState: 4)
				)
				((== gGNumber_2 301))
				((not local0) (= local0 1) (proc255_0 300 0))
			)
		)
	)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(= gGNumber_2 301)
				(gEgo illegalBits: 0 setMotion: MoveTo 155 160 self)
			)
			(2
				(gEgo setMotion: MoveTo 155 164 self)
			)
			(3 (= gGNumber_2 0) (proc0_1))
			(4
				(proc0_3)
				(gEgo
					illegalBits: 0
					setPri: 4
					setLoop: 3
					setMotion: MoveTo (gEgo x?) 200 self
				)
			)
			(5
				(= gGNumber_2 0)
				(global2 newRoom: 360)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(cond 
				((Said '/fish') (proc255_0 300 1))
				((Said '/awning') (proc255_0 300 2))
				((Said '/panties') (proc255_0 300 3))
				((Said '/eye') (proc255_0 300 4))
				((Said '/lip') (proc255_0 300 5))
				((Said '/dicklicker') (proc255_0 300 6))
				((Said '/spout') (proc255_0 300 7))
				((Said '[/area]') (proc255_0 300 8))
			)
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 300)
					(< (pEvent x?) 319)
					(> (pEvent y?) 169)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 322 179)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 89)
					(< (pEvent x?) 260)
					(> (pEvent y?) 50)
					(< (pEvent y?) 135)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999)
					(998
						(switch (Random 1 5)
							(1 (proc255_0 300 1))
							(2 (proc255_0 300 2))
							(3 (proc255_0 300 3))
							(4 (proc255_0 300 5))
							(5 (proc255_0 300 8))
						)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)

(instance atpSign of PV
	(properties
		y 133
		x 62
		view 300
		priority 7
		signal $4000
	)
)

(instance aSpout of Prop
	(properties
		y 56
		x 157
		view 300
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd)
	)
)
