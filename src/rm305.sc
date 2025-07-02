;;; Sierra Script 1.0 - (do not remove this comment)
(script# 305)
(include sci.sh)
(use Main)
(use n021)
(use AutoDoor)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm305 0
)

(local
	[local0 307]
)
(instance rm305 of Rm
	(properties
		picture 305
		east 250
		west 350
	)
	
	(method (init)
		(super init:)
		(gAddToPics
			add: atpPalmTree1
			add: atpPalmTree2
			add: atpPalmTree3
			add: atpPalmTree3a
			add: atpPalmTree4
			add: atpPalmTree5
			add: atpPalmTree6
			add: atpPalmTree7
			add: atpPalmTree8
			add: atpPalmTree9
			add: atpPalmTree10
			doit:
		)
		(if (> global87 16)
			(aSign setPri: 12 setCycle: Fwd isExtra: 1 init:)
		)
		(aDoor init:)
		(self setScript: RoomScript)
		(if (== gGNumber 350)
			(gEgo posn: 78 144 loop: 0)
		else
			(gEgo posn: 313 161)
		)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0
				(if (== gGNumber_2 4)
					(proc0_19 22)
					(= gGNumber_2 0)
					(= state 1)
					(= cycles 20)
				)
			)
			(1)
			(2 (proc255_0 305 5))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'look<in/cup') (proc255_0 305 0))
			((Said 'look>')
				(cond 
					((Said '/awning') (proc255_0 305 1))
					((Said '/palm,palm') (proc255_0 305 2))
					((Said '[/building,area]')
						(proc255_0 305 3)
						(if (not global108) (proc255_0 305 4 67 -1 144))
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
						(> (pEvent x?) 300)
						(< (pEvent x?) 319)
						(> (pEvent y?) 140)
						(< (pEvent y?) 180)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 324 171)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(or
						(proc0_26 atpPalmTree1 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree2 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree3 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree3a (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree4 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree5 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree6 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree7 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree8 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree9 (pEvent x?) (pEvent y?))
						(proc0_26 atpPalmTree10 (pEvent x?) (pEvent y?))
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(switch (Random 1 2)
								(1 (proc255_0 305 2))
								(2
									(proc255_0 305 3)
									(if (not global108) (proc255_0 305 4 67 -1 144))
								)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aSign (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 305 1))
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance atpPalmTree1 of PV
	(properties
		y 128
		x 143
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree2 of PV
	(properties
		y 131
		x 183
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree3 of PV
	(properties
		y 135
		x 225
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree3a of PV
	(properties
		y 139
		x 266
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree4 of PV
	(properties
		y 144
		x 311
		view 305
		loop 1
		priority 10
	)
)

(instance atpPalmTree5 of PV
	(properties
		y 161
		x 42
		view 305
		loop 1
		cel 1
		priority 13
		signal $4000
	)
)

(instance atpPalmTree6 of PV
	(properties
		y 169
		x 90
		view 305
		loop 1
		cel 1
		priority 14
		signal $4000
	)
)

(instance atpPalmTree7 of PV
	(properties
		y 175
		x 140
		view 305
		loop 1
		cel 1
		priority 15
		signal $4000
	)
)

(instance atpPalmTree8 of PV
	(properties
		y 180
		x 190
		view 305
		loop 1
		cel 1
		priority 15
		signal $4000
	)
)

(instance atpPalmTree9 of PV
	(properties
		y 185
		x 238
		view 305
		loop 1
		cel 1
		priority 15
		signal $4000
	)
)

(instance atpPalmTree10 of PV
	(properties
		y 192
		x 287
		view 305
		loop 1
		cel 1
		priority 15
		signal $4000
	)
)

(instance aSign of Prop
	(properties
		y 60
		x 149
		view 305
		loop 2
	)
)

(instance aDoor of AutoDoor
	(properties
		y 86
		x 93
		view 305
		entranceTo 350
	)
	
	(method (init)
		(super init:)
		(self setPri: 5)
	)
)
