;;; Sierra Script 1.0 - (do not remove this comment)
(script# 417)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)

(public
	regCasino 0
)

(instance regCasino of Rgn
	(properties)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((or (Said 'gamble/game') (Said 'gamble')) (proc255_0 417 0) (proc255_0 417 1 67 -1 144))
			((and global64 (Said 'increase/backstage')) (proc255_4 417 2 (++ global104)))
			((and global64 (Said 'increase/document')) (proc255_4 417 3 (++ global98)))
			((and global64 (Said 'increase/attorney')) (proc255_4 417 4 (++ global99)))
			((Said 'look>')
				(cond 
					(
					(Said '/gambler,entertainer,stair,couple,man,babe') (proc255_0 417 5))
					((Said '/rail') (proc255_0 417 6))
					((Said '/door') (proc255_0 417 7))
					((Said '/mirror')
						(proc255_0 417 8)
						(if (not (proc0_22 12))
							(proc0_19 12)
							(gGame changeScore: 2)
						)
					)
					((Said '[/area]') (proc255_0 417 9))
				)
			)
		)
	)
)
