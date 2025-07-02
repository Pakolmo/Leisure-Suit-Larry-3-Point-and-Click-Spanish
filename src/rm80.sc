;;; Sierra Script 1.0 - (do not remove this comment)
(script# 80)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)

(public
	rm80 0
)

(instance rm80 of Locale
	(properties)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said '/hair') (proc255_0 80 0))
			((Said '/entertainer')
				(proc255_0 80 1)
				(if (>= global88 3) (proc255_0 80 2 67 -1 144))
			)
			((Said 'give') (proc255_4 80 3 global82))
			(
			(or (Said '//buffet,buffet') (Said '/buffet,buffet')) (proc255_0 80 4))
			((Said '/man') (proc255_0 80 5) (proc255_0 80 6 67 -1 144))
			((Said '/eye') (proc255_0 80 7))
		)
	)
)
