;;; Sierra Script 1.0 - (do not remove this comment)
(script# 81)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)

(public
	rm81 0
)

(instance rm81 of Locale
	(properties)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said '/hair') (proc255_0 81 0))
			((Said '/larry') (proc255_0 81 1))
			((Said 'give') (proc255_4 81 2 global82))
			(
			(or (Said '//buffet,buffet') (Said '/buffet,buffet')) (proc255_0 81 3))
			((Said '/eye') (proc255_0 81 4))
		)
	)
)
