;;; Sierra Script 1.0 - (do not remove this comment)
(script# 266)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm266 0
)

(local
	local0
)
(instance rm266 of Rm
	(properties
		picture 266
	)
	
	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(if (< global88 3) (gAddToPics add: atpBikiniTop doit:))
		(gAddToPics add: atpBikiniBottom doit:)
		(User canInput: 0 mapKeyToDir: 0)
		(proc0_4)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== gCursorNumber 999)
			(gGame setCursor: 998 (HaveMouse))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc0_22 32)) (= seconds 3))
			)
			(1
				(proc0_19 32)
				(proc255_0 266 10)
				(proc255_0 266 11 67 -1 144)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'cease/look')
					(Said 'look<cease')
					(Said 'look/beach,area')
					(Said 'exit,done')
					(Said 'exit,exit,done,exit,go')
				)
				(proc0_6)
				(global2 newRoom: 260)
			)
			((Said 'address,ask,say') (proc255_0 266 0) (global2 newRoom: 265))
			((Said 'give') (proc255_0 266 1))
			((Said 'look>')
				(cond 
					((Said '/babe,body,maller') (proc255_0 266 2) (proc255_0 266 3))
					((Said '/boob')
						(if (>= global88 3)
							(proc255_0 266 4)
						else
							(proc255_0 266 5)
						)
					)
					((Said '/ass,bottom') (proc255_0 266 6))
					((Said '/clit,ball') (proc255_0 266 7))
					((Said '/eye,eye') (proc255_0 266 0) (global2 newRoom: 265))
					((Said '/calf') (proc255_0 266 8))
					((Said '[/area]') (proc255_0 266 9))
				)
			)
			((== (pEvent type?) evMOUSEBUTTON)
				(cond 
					((& (pEvent modifiers?) emSHIFT)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(gGCursorNumber
								(gGame setCursor: 991 (HaveMouse))
								(pEvent claimed: 1)
							)
							(991
								(gGame setCursor: 998 (HaveMouse))
								(pEvent claimed: 1)
							)
							(992
								(gGame setCursor: 998 (HaveMouse))
								(pEvent claimed: 1)
							)
							(999
								(gGame setCursor: 998 (HaveMouse))
								(pEvent claimed: 1)
							)
							(993
								(gGame setCursor: 996 (HaveMouse))
								(pEvent claimed: 1)
							)
							(996
								(gGame setCursor: 994 (HaveMouse))
								(pEvent claimed: 1)
							)
							(998
								(gGame setCursor: 995 (HaveMouse))
								(pEvent claimed: 1)
							)
							(995
								(gGame setCursor: 996 (HaveMouse))
								(pEvent claimed: 1)
							)
							(994
								(if
									(or
										(== gGCursorNumber 900)
										(== gGCursorNumber 994)
										(== gGCursorNumber 666)
										(== gGCursorNumber 992)
										(== gGCursorNumber 993)
									)
									(gGame setCursor: 991 (HaveMouse))
								else
									(gGame setCursor: gGCursorNumber (HaveMouse))
									(= gCursorNumber gGCursorNumber)
								)
								(pEvent claimed: 1)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(
						(and
							(> (pEvent x?) 83)
							(< (pEvent x?) 141)
							(> (pEvent y?) 9)
							(< (pEvent y?) 180)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(proc255_0 266 0)
								(gGame setCursor: 998)
								(global2 newRoom: 265)
							)
							(996 (proc255_0 266 1))
							(995
								(if (>= global88 3)
									(proc255_0 266 4)
								else
									(proc255_0 266 5)
								)
							)
							(991
								(proc0_6)
								(proc0_3)
								(= gCursorNumber 998)
								(gGame setCursor: 998)
								(global2 newRoom: 260)
							)
							(else  (pEvent claimed: 0))
						)
					)
				)
			)
		)
	)
)

(instance atpBikiniTop of PV
	(properties
		y 56
		x 98
		view 266
	)
)

(instance atpBikiniBottom of PV
	(properties
		y 91
		x 103
		view 266
		cel 1
	)
)
