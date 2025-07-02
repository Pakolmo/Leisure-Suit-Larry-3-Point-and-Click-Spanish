;;; Sierra Script 1.0 - (do not remove this comment)
(script# 699)
(include sci.sh)
(use Class_255_0)
(use Game)

(public
	rm699 0
)

(instance rm699 of Locale
	(properties)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'address/man,couple,babe') (proc255_0 699 0))
			((Said 'drain,(get<off)/sandal') (proc255_0 699 1))
			((Said '(look<up),look[/ceiling]') (proc255_0 699 2))
			((Said 'look/building,area') (proc255_0 699 3))
		)
	)
)
