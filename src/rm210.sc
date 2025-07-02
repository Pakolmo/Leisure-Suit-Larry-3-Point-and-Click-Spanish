;;; Sierra Script 1.0 - (do not remove this comment)
(script# 210)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm210 0
)

(local
	[local0 200]
)
(procedure (localproc_000c &tmp temp0)
	(proc255_0
		@local0
		67
		10
		5
		70
		290
		25
		(= temp0 (proc0_25 @local0))
		88
	)
	(return (+ 3 temp0))
)

(instance rm210 of Rm
	(properties
		picture 210
		south 220
	)
	
	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(cond 
			((not (proc0_22 25)) (Load rsVIEW 53))
			((not (proc0_22 20)) (Load rsVIEW 53))
			((not (proc0_22 25)) (Load rsVIEW 212) (aCredit1 init:) (aCredit2 init:))
		)
		(if (proc0_23 3) (Load rsVIEW 709) (aWood init:))
		(cond 
			((== gGNumber 200) (gEgo posn: 317 126 loop: 1))
			((== gGNumber 216) (gEgo posn: 2 163))
			((== gGNumber 213) (gEgo posn: 2 175))
			(else (gEgo posn: 317 175))
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
		(if (gEgo edgeHit?)
			(cond 
				((& (gEgo onControl:) $0008) (global2 newRoom: 200))
				((& (gEgo onControl:) $0004) (global2 newRoom: 216))
				((& (gEgo onControl:) $0010) (global2 newRoom: 220))
				((& (gEgo onControl:) $0002) (global2 newRoom: 213))
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not (proc0_22 25)) (= cycles 30))
					((not (proc0_22 20)) (= cycles 20) (++ state))
				)
			)
			(1
				(Format @local0 210 5)
				(= seconds (localproc_000c))
			)
			(2
				(proc0_19 25)
				(if (not (proc0_22 20))
					(aCredit1
						view: 53
						posn: 0 121
						setCycle: Fwd
						cycleSpeed: 1
						ignoreActors:
						init:
						setPri: 12
					)
					(Format @local0 210 6)
					(= seconds (localproc_000c))
				)
			)
			(3
				(aCredit1 dispose:)
				(= seconds 0)
			)
			(4
				(= cycles (= seconds 0))
				(proc0_6)
				(proc0_3)
				(if (< (gEgo x?) (aWood x?))
					(gEgo
						illegalBits: 0
						setMotion: MoveTo (- (aWood x?) 19) (gEgo y?) self
					)
				else
					(gEgo
						illegalBits: 0
						setMotion: MoveTo (+ (aWood x?) 19) (gEgo y?) self
					)
				)
			)
			(5
				(gEgo
					view: 709
					loop: (> (gEgo x?) (aWood x?))
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(6
				(aWood hide:)
				(gEgo get: 3 setCycle: Beg self)
			)
			(7
				(proc0_1)
				(gGame changeScore: 2)
				(proc255_0 210 7)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if
			(and
				(not (super handleEvent: pEvent))
				(not (pEvent claimed?))
				gTheNewDialog
				(== (pEvent message?) KEY_RETURN)
				(== (pEvent type?) evKEYBOARD)
			)
			(pEvent claimed: 1)
			(proc0_5)
			(self cue:)
		)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(if (Said '/palm')
				(proc255_4
					210
					0
					(if (proc0_23 3)
						{ Bajo sus ramas extendidas yace una hermosa pieza de madera, probablemente cortada por un nativo y luego olvidada.}
					else
						{}
					)
				)
			)
			(if
			(and (proc0_23 3) (Said '/backdrop,granadilla'))
				(proc255_0 210 1)
			)
			(if (Said '[/area]') (proc255_0 210 2))
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 0)
					(< (pEvent x?) 20)
					(> (pEvent y?) 145)
					(< (pEvent y?) 165)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -5 158)
					)
					(998)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 0)
					(< (pEvent x?) 15)
					(> (pEvent y?) 168)
					(< (pEvent y?) 185)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -5 177)
					)
					(998)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 15)
					(< (pEvent x?) 305)
					(> (pEvent y?) 21)
					(< (pEvent y?) 125)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(switch (Random 1 2)
							(1
								(proc255_4
									210
									0
									(if (proc0_23 3)
										{ Bajo sus ramas extendidas yace una hermosa pieza de madera, probablemente cortada por un nativo y luego olvidada.}
									else
										{}
									)
								)
							)
							(2 (proc255_0 210 2))
						)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 290)
					(< (pEvent x?) 319)
					(> (pEvent y?) 83)
					(< (pEvent y?) 144)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 335 123)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 300)
					(< (pEvent x?) 319)
					(> (pEvent y?) 168)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 335 174)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if (proc0_26 aWood (pEvent x?) (pEvent y?))
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							((not (proc0_23 3)) (proc255_0 210 3))
							((not (& (gEgo onControl:) $0040)) (proc255_0 210 4))
							(else (self changeState: 4))
						)
					)
					(998
						(if (proc0_23 3) (proc255_0 210 1))
					)
				)
			)
		)
	)
)

(instance aWood of View
	(properties
		y 161
		x 223
		view 210
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 240
		view 212
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 131
		x 240
		view 212
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
				(proc0_19 25)
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
