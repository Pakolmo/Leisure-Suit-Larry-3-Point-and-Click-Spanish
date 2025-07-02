;;; Sierra Script 1.0 - (do not remove this comment)
(script# 416)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Extra)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm416 0
)

(instance rm416 of Rm
	(properties
		picture 416
		east 450
		west 410
	)
	
	(method (init)
		(Load rsVIEW 415)
		(Load rsVIEW 416)
		(Load rsVIEW 417)
		(Load rsVIEW 418)
		(Load rsVIEW 419)
		(super init:)
		(self setRegions: 417)
		(cond 
			((== gGNumber 410) (gEgo posn: 1 143))
			((or (== gGNumber_2 11) (> (gEgo yLast?) 180)) (gEgo posn: 315 136))
			(else (gEgo posn: 290 122))
		)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
		(aCraps init: isExtra: 1)
		(aCard init: isExtra: 1)
		(if (> global87 16) (aWalker init:) (aAlterEgo init:))
	)
	
	(method (doit)
		(super doit:)
		(if
			(or
				(& (gEgo onControl:) $0002)
				(and (== gGNumber_2 11) (& (gEgo onControl:) $0004))
			)
			(global2 newRoom: 450)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 53)
					(< (pEvent x?) 245)
					(> (pEvent y?) 21)
					(< (pEvent y?) 113)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(switch (Random 0 1)
							(1
								(proc255_0 417 8)
								(if (not (proc0_22 12))
									(proc0_19 12)
									(gGame changeScore: 2)
								)
							)
							(0 (proc255_0 417 9))
						)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 260)
					(< (pEvent x?) 288)
					(> (pEvent y?) 78)
					(< (pEvent y?) 128)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 275 75)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 1)
					(< (pEvent x?) 8)
					(> (pEvent y?) 123)
					(< (pEvent y?) 157)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -4 145)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 308)
					(< (pEvent x?) 319)
					(> (pEvent y?) 117)
					(< (pEvent y?) 133)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 322 134)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)

(instance aAlterEgo of Act
	(properties
		view 700
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			view: (gEgo view?)
			setPri: 4
			posn: (gEgo x?) 122
			ignoreHorizon:
			ignoreActors:
		)
	)
	
	(method (doit)
		(aAlterEgo
			view: (gEgo view?)
			loop:
			(switch (gEgo loop?)
				(3 2)
				(2 3)
				(else  (gEgo loop?))
			)
			cel: (gEgo cel?)
			x: (gEgo x?)
			y: (- 125 (/ (- (gEgo y?) 127) 2))
		)
		(super doit:)
	)
)

(instance aCraps of Extra
	(properties
		y 60
		x 122
		view 414
		loop 3
		cel 11
		cycleSpeed 0
		cycleType 1
		hesitation 11
		pauseCel 11
		minPause 22
		maxPause 111
	)
)

(instance aCard of Extra
	(properties
		y 60
		x 160
		view 414
		loop 1
		minPause 11
		maxPause 55
		minCycles 15
		maxCycles 44
	)
)

(instance aWalker of Act
	(properties
		y 15
		x 119
		view 415
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setCycle: Walk
			setStep: 2 1
			setScript: WalkerScript
		)
	)
)

(instance WalkerScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0 (= seconds (Random 2 6)))
			(1
				(switch (Random 0 6)
					(0
						(aWalker
							view: (Random 415 419)
							posn: 72 15
							setPri: 1
							setMotion: MoveTo 198 15 self
						)
					)
					(1
						(aWalker
							view: (Random 415 419)
							posn: 198 15
							setPri: 1
							setMotion: MoveTo 72 15 self
						)
					)
					(2
						(aWalker
							view: 415
							posn: 132 32
							setPri: 0
							setMotion: MoveTo 132 142 self
						)
					)
					(3
						(aWalker
							view: 415
							posn: 132 142
							setPri: 0
							setMotion: MoveTo 132 32 self
						)
					)
					(else  (= seconds 2))
				)
				(= state -1)
			)
		)
	)
)
