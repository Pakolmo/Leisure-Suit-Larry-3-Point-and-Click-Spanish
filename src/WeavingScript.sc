;;; Sierra Script 1.0 - (do not remove this comment)
(script# 44)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use InvI)
(use Obj)

(public
	WeavingScript 0
)

(local
	gEgoIllegalBits
)
(instance WeavingScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(= global101 (gGame setSpeed: 6))
				(= gEgoIllegalBits (gEgo illegalBits?))
				(gEgo
					view: 717
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(proc255_0 44 0 82 4 0 0)
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(gEgo loop: 2)
				(= seconds 2)
			)
			(3
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(4
				((Inv at: 4) view: 23)
				(Format ((Inv at: 4) name?) {Falda_Nativa_})
				(gGame changeScore: 30)
				(proc0_1 0)
				(gEgo illegalBits: gEgoIllegalBits)
				(gGame setScript: 0 setSpeed: global101)
				(DisposeScript 44)
			)
		)
	)
)
