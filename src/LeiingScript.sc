;;; Sierra Script 1.0 - (do not remove this comment)
(script# 42)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use InvI)
(use Obj)

(public
	LeiingScript 0
)

(local
	gEgoIllegalBits
)
(instance LeiingScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(= global101 (gGame setSpeed: 6))
				(= gEgoIllegalBits (gEgo illegalBits?))
				(gEgo
					view: 710
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(proc255_0 42 0 82 11 0 0)
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
				((Inv at: 11) view: 26)
;;;				(Format ((Inv at: 11) name?) {A Quick Lei__})
				(Format ((Inv at: 11) name?) {Un Collar____})
				(if (not (proc0_22 55))
					(proc0_19 55)
					(gGame changeScore: 50)
					(proc255_0 42 2 67 -1 144)
				else
					(proc255_0 42 3 67 -1 144)
				)
				(proc0_1 0)
				(gEgo illegalBits: gEgoIllegalBits)
				(gGame setScript: 0 setSpeed: global101)
				(DisposeScript 42)
			)
		)
	)
)
