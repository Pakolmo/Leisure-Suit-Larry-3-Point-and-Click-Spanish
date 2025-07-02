;;; Sierra Script 1.0 - (do not remove this comment)
(script# 299)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use Obj)

(public
	rm299 0
)

(instance rm299 of Locale
	(properties)
	
	(method (init)
		(super init:)
		(if
			(not
				(proc999_5
					gGNumber
					200
					203
					210
					213
					216
					220
					230
					235
					240
					245
					250
					253
					300
					305
					310
				)
			)
			(gTheMusic stop: number: 299 loop: global72 play:)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'address/man,couple,babe') (proc255_0 299 0))
			((Said 'carve,get/blade') (proc255_0 299 1))
			((Said '/cab') (proc255_0 299 2))
			((Said '/auto,auto') (proc255_0 299 3) (proc255_0 299 4 67 -1 144))
			((Said 'climb/palm') (proc255_0 299 5))
			((Said 'drain,(get<off)/sandal')
				(proc255_4
					299
					6
					(if global108
						{rasga tus medias de nylon}
					else
						{ens{ciate los calcetines blancos}
					)
				)
			)
			((Said 'look>')
				(cond 
					((Said '/up,air') (proc255_0 299 7))
					((Said '/auto,camp') (proc255_0 299 8))
					((Said '/carpet') (proc255_0 299 9))
					((Said '/palm,bush') (proc255_0 299 10))
				)
			)
		)
	)
)
