;;; Sierra Script 1.0 - (do not remove this comment)
(script# 90)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use User)
(use TheMenuBar)

(public
	rm90 0
)

(instance rm90 of Rm
	(properties
		picture 90
	)
	
	(method (init)
		(proc0_5)
		(super init:)
		(TheMenuBar hide:)
		(SL disable:)
		(gEgo hide:)
		(proc0_3)
		(User canInput: 1)
		(Animate 0)
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(== (pEvent type?) evMOUSERELEASE)
				(pEvent claimed?)
			)
			(return)
		)
		(proc255_0
			{Lo siento, pero desde aqu|, todo lo que puedes hacer es cerrar el juego.}
		)
		(proc255_0 90 1 67 -1 144)
		(pEvent claimed: 1)
	)
)
