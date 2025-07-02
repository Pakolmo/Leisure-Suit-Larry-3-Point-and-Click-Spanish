;;; Sierra Script 1.0 - (do not remove this comment)
(script# 200)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm200 0
)

(local
	local0
	[local1 222]
)
(procedure (localproc_000c &tmp temp0)
	(proc255_0
		@local1
		67
		10
		5
		70
		290
		25
		(= temp0 (proc0_25 @local1))
		88
	)
	(return (+ 3 temp0))
)

(instance rm200 of Rm
	(properties
		picture 200
		east 210
		south 210
	)
	
	(method (init)
		(Load rsVIEW 200)
		(super init:)
		(self setScript: RoomScript)
		(if (and (proc0_22 17) (not (proc0_22 24)))
			(Load rsVIEW 201)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(gAddToPics add: atpBinocular1 add: atpBinocular2 doit:)
		(if (and (!= gGNumber 203) (!= gGNumber 206))
			(gEgo posn: 315 167 loop: 1)
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
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc0_22 24)) (= seconds 5))
			)
			(1
				(Format @local1 200 18)
				(= seconds (localproc_000c))
			)
			(2
				(proc0_19 24)
				(if (not (proc0_22 20))
					(Format @local1 200 19)
					(= seconds (localproc_000c))
				)
			)
			(3 (= seconds 0))
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (super handleEvent: pEvent))
				gTheNewDialog
				(== (pEvent message?) KEY_RETURN)
				(== (pEvent type?) evKEYBOARD)
			)
			(pEvent claimed: 1)
			(proc0_5)
			(self cue:)
		)
		(cond 
			((Said '/binocular,binocular>')
				(cond 
					((Said 'get') (proc255_0 200 0))
					((Said 'use,(look<through,in)')
						(cond 
							(global108 (proc255_0 200 1))
							(
								(and
									(not (& (gEgo onControl:) $0004))
									(not (& (gEgo onControl:) $0008))
								)
								(proc0_10)
							)
							((& (gEgo onControl:) $0008) (proc255_0 200 2))
							((proc0_22 16) (proc255_0 200 3))
							(else (proc0_6) (global2 newRoom: 206))
						)
					)
					((Said 'look') (proc255_0 200 4))
				)
			)
			((Said 'get/awning') (proc255_0 200 5) (proc255_0 200 6 67 -1 144))
			((or (Said 'look/air') (Said 'up<look')) (proc255_0 200 7))
			((Said 'look>')
				(cond 
					((Said '/air,up') (proc255_0 200 7))
					((Said '/cliff,land,cliff') (proc255_0 200 8))
					((Said '/fence,rail') (proc255_0 200 9))
					((Said '/cliff,edge') (proc255_0 200 10))
					((Said '/bay,beach,point,bay,bay') (proc255_0 200 11))
					((Said '/camp,down,building,casino,hotel,trap')
						(proc255_0 200 12)
						(if (<= global88 1) (proc255_0 200 13))
					)
					((Said '/blade,carpet,carpet') (proc255_0 200 14))
					((Said '/bird') (proc255_0 200 15))
					((Said '/awning')
						(if (& (gEgo onControl:) $0002)
							(if (not (proc0_22 18))
								(proc0_19 18)
								(gGame changeScore: 2)
							)
							(proc0_6)
							(global2 newRoom: 203)
						else
							(proc0_10)
						)
					)
					((Said '[/look,area]') (proc255_0 200 16) (proc255_0 200 17))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 310)
						(< (pEvent x?) 319)
						(> (pEvent y?) 146)
						(< (pEvent y?) 169)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 320 160)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 318)
						(> (pEvent y?) 28)
						(< (pEvent y?) 53)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(994 (proc255_0 200 7))
						(998 (proc255_0 200 8))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 75)
						(> (pEvent y?) 84)
						(< (pEvent y?) 186)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(994 (proc255_0 200 7))
						(998
							(proc255_0 200 16)
							(proc255_0 200 17)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 159)
						(< (pEvent x?) 170)
						(> (pEvent y?) 92)
						(< (pEvent y?) 110)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(if (& (gEgo onControl:) $0002)
								(if (not (proc0_22 18))
									(proc0_19 18)
									(gGame changeScore: 2)
								)
								(proc0_6)
								(global2 newRoom: 203)
							else
								(proc0_10)
								(gEgo setMotion: MoveTo 163 112)
							)
						)
						(995
							(proc255_0 200 5)
							(proc255_0 200 6 67 -1 144)
						)
						(999
							(gEgo setMotion: MoveTo 163 112)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(or
						(proc0_26 atpBinocular1 (pEvent x?) (pEvent y?))
						(proc0_26 atpBinocular2 (pEvent x?) (pEvent y?))
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								(global108 (proc255_0 200 1))
								(
									(and
										(not (& (gEgo onControl:) $0004))
										(not (& (gEgo onControl:) $0008))
									)
									(proc0_10)
								)
								((proc0_22 16) (proc255_0 200 3))
								(else (proc0_6) (global2 newRoom: 206))
							)
						)
						(995 (proc255_0 200 0))
						(else  (pEvent claimed: 0))
					)
					(proc0_5)
				)
			)
		)
	)
)

(instance atpBinocular1 of PV
	(properties
		y 82
		x 137
		view 200
		signal $4000
	)
)

(instance atpBinocular2 of PV
	(properties
		y 79
		x 205
		view 200
		loop 6
		cel 1
		signal $4000
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 240
		view 201
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 240
		view 201
		loop 1
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(proc0_19 24)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)
