;;; Sierra Script 1.0 - (do not remove this comment)
(script# 70)
(include sci.sh)
(use Class_255_0)
(use Game)

(public
	rm70 0
)

(instance rm70 of Locale
	(properties)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			(
				(or
					(Said 'embrace')
					(Said '/embrace')
					(Said '//embrace')
					(Said '/coconut')
					(Said '//coconut')
					(Said '/boob')
					(Said '//boob')
				)
				(proc255_0 70 0)
			)
			((Said '/ass') (proc255_0 70 1))
			((Said '/bracelet') (proc255_0 70 2))
			((Said '/body') (proc255_0 70 3))
			((Said '/ankle') (proc255_0 70 4))
			((Said '/hair') (proc255_0 70 5))
			((Said '/ear') (proc255_0 70 6))
			((Said '/nose') (proc255_0 70 7) (proc255_0 70 8 67 -1 144))
			((Said '/lip,lip') (proc255_0 70 9))
			((Said '/eye') (proc255_0 70 10))
			((Said '/dicklicker') (proc255_0 70 11))
		)
	)
)
