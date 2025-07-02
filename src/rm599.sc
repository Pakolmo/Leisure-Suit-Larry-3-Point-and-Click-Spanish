;;; Sierra Script 1.0 - (do not remove this comment)
(script# 599)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use Obj)

(public
	rm599 0
)

(instance rm599 of Locale
	(properties)
	
	(method (init)
		(if (< global66 800) (= global66 800))
		(super init:)
		(if (not (proc999_5 gGNumber 510 520 523 540 550))
			(gTheMusic number: 599 loop: global72 play:)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'address/man,couple,babe') (proc255_0 599 0))
			((Said 'use/coconut') (proc255_0 599 1))
			((Said '/bra') (proc255_0 599 2))
			((Said 'climb') (proc255_0 599 3))
			((Said '/bush') (proc255_0 599 4) (proc255_0 599 5 67 -1 144))
			((Said '/carpet') (proc255_0 599 6))
			(
				(and
					(gEgo has: 19)
					(or
						(Said 'drink/coconut')
						(Said 'drink/milk')
						(Said 'drink/coconut/milk')
					)
				)
				(proc255_0 599 7)
				(proc255_0 599 8 67 -1 144)
			)
			((Said 'look>')
				(cond 
					((Said '/up,air') (proc255_0 599 9))
					((Said '/boulder') (proc255_0 599 10))
					((Said '/carpet') (proc255_0 599 11))
					((Said '/palm,bush') (proc255_0 599 12))
				)
			)
		)
	)
)
