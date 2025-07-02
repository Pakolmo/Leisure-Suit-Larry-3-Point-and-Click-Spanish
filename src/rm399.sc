;;; Sierra Script 1.0 - (do not remove this comment)
(script# 399)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use Obj)

(public
	rm399 0
)

(instance rm399 of Locale
	(properties)
	
	(method (init)
		(super init:)
		(if (not (proc999_5 gGNumber 360 370 375 380 390))
			(gTheMusic number: 399 loop: global72 play:)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said '/carpet') (proc255_0 399 0))
			((Said '(look<up),look[/ceiling]') (proc255_0 399 1))
			((Said '/wall') (proc255_0 399 2))
			((Said '/door') (proc255_4 399 3 global82))
		)
	)
)
