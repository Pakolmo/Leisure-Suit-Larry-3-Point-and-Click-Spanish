;;; Sierra Script 1.0 - (do not remove this comment)
(script# 335)
(include sci.sh)
(use Main)
(use rm71)
(use Class_255_0)
(use Game)
(use InvI)
(use User)
(use Obj)

(public
	rm335 0
)
(synonyms
	(man man dale)
)

(local
	local0
	local1
	local2
)
(instance rm335 of Rm
	(properties
		picture 335
	)
	
	(method (init)
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(self setRegions: 71 setScript: RoomScript)
		(proc0_13 71 1 154 78)
		(proc0_13 71 2 188 81)
		(proc0_13 71 3 152 78)
		(proc0_13 71 4 187 81)
		(proc0_13 71 5 170 106)
		(proc0_13 71 6 168 114)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc71_2 335 45)
				(proc71_3 335 46)
				(proc71_1 2 55)
				(= cycles 50)
			)
			(2 (global2 newRoom: 330))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said '(go<out),date')
					(Said 'bang')
					(Said 'get/*/building')
					(Said 'ask/*/date')
					(Said 'ask,get/date')
					(Said '(let<make),make/enjoy')
					(Said '*/make/enjoy')
					(Said 'go/bed,penthouse')
					(Said 'give/job<blow')
					(Said 'give/blow<job')
					(Said 'give/head')
					(Said 'give/head<job')
					(Said 'eat,blow,eat,eat/man,ball,coconut,ball')
				)
				(proc71_3 335 0)
				(proc71_1 4 4)
			)
			((Said '/bill,health') (proc255_0 335 1))
			(
			(or (Said 'show/ball/entertainer') (Said 'show/ball')) (proc71_2 335 2) (proc71_2 335 3) (proc71_1 2 20))
			(
				(or
					(Said 'aid')
					(Said '/aid')
					(Said '//larry')
					(Said '/larry')
				)
				(proc71_2 335 4)
				(proc71_3 335 5)
			)
			(
				(or
					(Said '/maze,bush,art,bamboo')
					(Said '//maze,bush,art,bamboo')
				)
				(proc71_3 335 6)
			)
			((Said '/bar,blackboard,drink,club,dance') (proc71_3 335 7))
			((Said 'give')
				(if (proc0_23 14 330)
					(proc71_3 335 8)
				else
					(proc71_3 335 9)
				)
			)
			((Said 'address')
				(cond 
					((and (not local2) (not (gEgo has: 15))) (= local2 1) (proc71_3 335 10))
					((and (not local1) (not (gEgo has: 16))) (= local1 1) (proc71_3 335 11))
					(
						(and
							(not local0)
							(or
								(not (gEgo has: 13))
								(!= ((Inv at: 13) view?) 29)
							)
						)
						(= local0 1)
						(proc71_3 335 12)
					)
					(else (proc71_2 335 13) (proc71_3 335 14))
				)
			)
			((Said 'make/joke')
				(proc71_2 335 15)
				(proc71_2 335 16 67 -1 144)
				(proc71_3 335 17)
				(proc71_1 7 22)
			)
			((Said 'enjoy/ya') (proc71_2 335 18) (proc71_3 335 19) (proc71_1 5 44))
			(
				(or
					(Said 'cease/look')
					(Said 'look<cease')
					(Said 'look/area')
					(Said 'done,exit,exit,done,exit,go')
				)
				(self changeState: 1)
			)
			((Said 'embrace') (proc255_0 335 20))
			((Said '/beard') (proc255_0 335 21) (proc255_0 335 22 67 -1 144))
			((Said '/ass') (proc255_0 335 23))
			((Said '/bracelet') (proc255_0 335 24))
			((Said '/cloth') (proc255_0 335 25))
			((Said '/body') (proc255_0 335 26))
			((Said '/ankle') (proc255_0 335 27))
			((Said '/hair') (proc255_0 335 28))
			((Said '/ear') (proc255_0 335 29))
			((Said '/nose') (proc255_0 335 30))
			((Said '/lip,lip') (proc255_0 335 31))
			((Said '/eye') (proc255_0 335 32))
			(
				(or
					(Said 'caress,grab,caress')
					(Said '/ball,ball,coconut')
				)
				(proc71_2 335 33)
				(proc71_3 335 34)
				(proc71_1 5 44)
			)
			((Said '/dicklicker') (proc255_0 335 35))
			((Said 'look>')
				(cond 
					((Said '/calf') (proc71_3 335 36) (proc71_1 3 22))
					((Said '/bracelet') (proc255_0 335 37))
					((Said '/ear') (proc255_0 335 38))
					((Said '/boob') (proc255_0 335 39) (proc71_3 335 40) (proc71_1 6 12))
					((Said '[/area,man,man]') (proc255_0 335 41) (proc71_3 335 42) (proc71_1 2 33))
				)
			)
			(
				(or
					(Said '(out<go),dance,show,date/')
					(Said 'get/man/building')
					(Said 'ask/man/date')
					(Said
						'go/area,backdrop,comedian,club,date,exit,bar,show,dance'
					)
				)
				(proc71_2 335 43)
				(proc71_3 335 44)
			)
			((== (pEvent type?) evMOUSEBUTTON)
				(if (& (pEvent modifiers?) emSHIFT)
					(switch gCursorNumber
						(gGCursorNumber
							(gGame setCursor: 991 (HaveMouse))
							(pEvent claimed: 1)
						)
						(991
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
					)
				else
					(if (== gCursorNumber 999)
						(gGame setCursor: 998 (HaveMouse))
					)
					(if
						(and
							(or
								(proc0_27 140 167 75 82 pEvent)
								(proc0_27 180 200 75 83 pEvent)
							)
							(== gCursorNumber 998)
						)
						(proc255_0 335 32)
						(pEvent claimed: 1)
					)
					(if
						(and
							(proc0_27 164 181 83 100 pEvent)
							(== gCursorNumber 998)
						)
						(proc255_0 335 30)
						(pEvent claimed: 1)
					)
					(if
						(and
							(proc0_27 115 130 70 96 pEvent)
							(== gCursorNumber 998)
						)
						(proc255_0 335 29)
						(pEvent claimed: 1)
					)
					(if (proc0_27 153 185 108 122 pEvent)
						(switch gCursorNumber
							(998
								(proc255_0 335 31)
								(pEvent claimed: 1)
							)
							(996
								(switch (Random 1 3)
									(1
										(proc71_2 335 15)
										(proc71_2 335 16 67 -1 144)
										(proc71_3 335 17)
										(proc71_1 7 22)
									)
									(2
										(proc71_2 335 18)
										(proc71_3 335 19)
										(proc71_1 5 44)
									)
									(3
										(proc71_2 335 4)
										(proc71_3 335 5)
									)
								)
								(pEvent claimed: 1)
							)
						)
					)
					(if (proc0_27 126 231 21 62 pEvent)
						(switch gCursorNumber
							(998
								(proc255_0 335 28)
								(pEvent claimed: 1)
							)
						)
					)
					(if
						(and
							(proc0_27 108 232 21 187 pEvent)
							(== (pEvent claimed?) 0)
						)
						(switch gCursorNumber
							(994
								(cond 
									((and (not local2) (not (gEgo has: 15))) (= local2 1) (proc71_3 335 10))
									((and (not local1) (not (gEgo has: 16))) (= local1 1) (proc71_3 335 11))
									(
										(and
											(not local0)
											(or
												(not (gEgo has: 13))
												(!= ((Inv at: 13) view?) 29)
											)
										)
										(= local0 1)
										(proc71_3 335 12)
									)
									(else (proc71_2 335 13) (proc71_3 335 14))
								)
							)
							(991
								(proc0_3)
								(self changeState: 1)
							)
							(else  (pEvent claimed: 0))
						)
					)
				)
			)
		)
	)
)
