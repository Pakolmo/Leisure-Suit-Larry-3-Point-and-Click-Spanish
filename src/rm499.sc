;;; Sierra Script 1.0 - (do not remove this comment)
(script# 499)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use Obj)

(public
	rm499 0
)

(instance rm499 of Locale
	(properties)
	
	(method (init)
		(super init:)
		(if
		(not (proc999_5 gGNumber 400 410 415 416 420 460))
			(gTheMusic number: 499 loop: global72 play:)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'address/man,couple,babe') (proc255_0 499 0))
			((Said 'drain,(get<off)/sandal')
				(proc255_4
					499
					1
					(if global108
						{rasga tus medias de nylon}
					else
						{ensucia esos calcetines blancos}
					)
				)
			)
			((Said 'gamble') (proc255_0 499 2))
			((Said '/art,art') (proc255_0 499 3))
			((Said '(look<up),look[/ceiling]') (proc255_0 499 4))
			((Said '/casino,gambling,building') (proc255_0 499 5))
			((Said 'look>')
				(cond 
					((Said '/building,casino,area') (proc255_0 499 6))
					((Said '/auto,camp') (proc255_0 499 7))
					((Said '/carpet') (proc255_0 499 8) (proc255_0 499 9 67 -1 144))
				)
			)
			((Said '/casino') (proc255_0 499 10))
		)
	)
)
