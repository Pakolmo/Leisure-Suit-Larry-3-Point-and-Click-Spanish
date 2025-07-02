;;; Sierra Script 1.0 - (do not remove this comment)
(script# 43)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use InvI)
(use Obj)

(public
	CarvingScript 0
)

(local
	gEgoIllegalBits
)
(instance CarvingScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gGNumber_2 0)
					(= cycles 1)
				else
					(proc0_3)
					(= global101 (gGame setSpeed: 6))
					(= gEgoIllegalBits (gEgo illegalBits?))
					(gEgo view: 711 loop: 0 cel: 0 setCycle: End self)
				)
				(proc255_0 43 0 82 3 0 0)
			)
			(1
				(if (!= gGNumber_2 0)
					(= cycles 1)
				else
					(gEgo loop: 1 cel: 0 setCycle: Fwd)
					(= cycles (* 10 (NumCels gEgo)))
				)
			)
			(2
				((Inv at: 3) view: (if (>= global88 2) 22 else 34))
				(Format ((Inv at: 3) name?) 43 1)
				(gGame changeScore: 50)
				(if (== gGNumber_2 0)
					(proc0_4)
					(proc0_1 0)
					(gEgo illegalBits: gEgoIllegalBits)
					(gGame setSpeed: global101)
				)
				(gGame setScript: 0)
				(DisposeScript 43)
			)
		)
	)
)
