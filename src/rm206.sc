;;; Sierra Script 1.0 - (do not remove this comment)
(script# 206)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm206 0
)

(local
	local0
	local1
)
(instance rm206 of Rm
	(properties
		picture 206
	)
	
	(method (init)
		(proc0_3)
		(User canControl: 1)
		(User canInput: 1)
		(= gCursorNumber 998)
		(gGame setCursor: 998)
		(Load rsSOUND 206)
		(super init:)
		(self setScript: RoomScript)
		(aShade1 init:)
		(aShade2 init:)
		(aShade3 init:)
		(aGull init:)
		(aGirl init:)
		(= global101 (gGame setSpeed: 6))
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= local1 1) (= seconds 3))
			(1
				(aGirl setMotion: MoveTo 10 109 self)
				(= cycles 11)
			)
			(2
				(gTheMusic number: 206 loop: -1 play:)
			)
			(3
				(gAddToPics
					add: atpWall1
					add: atpWall2
					add: atpWall3
					doit:
				)
				(= cycles 3)
				(= local1 2)
			)
			(4
				(aGirl setCycle: Walk setMotion: MoveTo 111 109 self)
			)
			(5
				(aGirl
					setLoop: 4
					setCel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(6
				(= local1 3)
				(aGirl
					setLoop: 5
					setCel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(7
				(aGirl setCycle: Beg cycleSpeed: 3)
				(aShade1
					setMotion: MoveTo 113 (- 102 (* 8 global88)) self
				)
			)
			(8
				(aShade1 stopUpd:)
				(aGirl
					setLoop: 4
					setCel: 255
					setCycle: Beg self
					cycleSpeed: 1
				)
			)
			(9
				(aGirl
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 162 109 self
					cycleSpeed: 0
				)
			)
			(10
				(aGirl
					setLoop: 4
					setCel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(11
				(aGirl
					setLoop: 5
					setCel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(12
				(aGirl setCycle: Beg cycleSpeed: 3)
				(aShade2
					setMotion: MoveTo 169 (- 102 (* 8 global88)) self
				)
			)
			(13
				(aShade2 stopUpd:)
				(aGirl
					setLoop: 4
					setCel: 255
					setCycle: Beg self
					cycleSpeed: 1
				)
			)
			(14
				(aGirl
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 220 109 self
					cycleSpeed: 0
				)
			)
			(15
				(aGirl
					setLoop: 4
					setCel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(16
				(aGirl
					setLoop: 5
					setCel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(17
				(aGirl setCycle: Beg cycleSpeed: 3)
				(aShade3
					setMotion: MoveTo 225 (- 102 (* 8 global88)) self
				)
			)
			(18
				(aShade3 stopUpd:)
				(= cycles 22)
			)
			(19
				(aGirl
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 169 109 self
					cycleSpeed: 0
				)
			)
			(20
				(= local1 4)
				(aGirl
					setLoop: 6
					setCel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(21 (= cycles (+ 8 global88)))
			(22
				(aGirl setLoop: 7 setCel: 0 setCycle: End self)
			)
			(23 (= cycles (+ 8 global88)))
			(24
				(= local1 5)
				(gTheMusic fade:)
				(aGirl
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 300 109 self
					cycleSpeed: 0
				)
			)
			(25 (= local1 6) (= seconds 3))
			(26
				(proc0_19 16)
				(gGame changeScore: 2 setSpeed: global101)
				(proc255_0 206 15)
				(proc0_4)
				(gGame setCursor: 998 (HaveMouse))
				(global2 newRoom: 200)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'look/area')
					(Said 'look<cease,away')
					(Said 'cease/look')
					(Said 'look<cease/awning')
					(Said 'exit,cease')
					(Said 'backdrop/binocular')
				)
				(proc0_6)
				(= gGNumber_2 gGGNumber_2)
				(global2 newRoom: 200)
			)
			((Said 'hear/babe') (proc255_0 206 0))
			((Said 'address/babe') (proc255_0 206 1))
			((Said '/panties,panties') (proc255_0 206 2))
			((Said 'drag/binocular') (proc255_0 206 3) (proc255_0 206 4 67 -1 144))
			((Said 'look<in/binocular') (proc255_0 206 5))
			((Said 'look/area') (proc255_0 206 6) (proc255_0 206 7 67 -1 144))
			((Said 'look[/babe]')
				(switch local1
					(1 (proc255_4 206 8 global82))
					(2 (proc255_0 206 9))
					(3 (proc255_0 206 10))
					(4 (proc255_0 206 11))
					(5 (proc255_0 206 12))
					(6 (proc255_0 206 13))
					(else  (proc255_0 206 14))
				)
			)
			((== (pEvent type?) evMOUSEBUTTON)
				(pEvent claimed: 1)
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
							(gGame setCursor: 996 (HaveMouse))
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
					(if (== gCursorNumber 998)
						(if (proc0_26 aGirl (pEvent x?) (pEvent y?))
							(switch local1
								(1 (proc255_4 206 8 global82))
								(2 (proc255_0 206 9))
								(3 (proc255_0 206 10))
								(4 (proc255_0 206 11))
								(5 (proc255_0 206 12))
								(6 (proc255_0 206 13))
								(else  (proc255_0 206 14))
							)
						else
							(proc255_0 206 6)
							(proc255_0 206 7 67 -1 144)
						)
					)
					(if (== gCursorNumber 991)
						(proc0_6)
						(gGame setCursor: 998 setSpeed: global101)
						(gGame setCursor: 998 (HaveMouse))
						(pEvent claimed: 1)
						(global2 newRoom: 200)
					)
					(if (== gCursorNumber 996) (proc255_0 206 0))
				)
			)
			(else (pEvent claimed: 0))
		)
	)
)

(instance aShade1 of Act
	(properties
		y 64
		x 113
		view 206
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setLoop: 0 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aShade2 of Act
	(properties
		y 64
		x 169
		view 206
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setLoop: 0 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aShade3 of Act
	(properties
		y 64
		x 225
		view 206
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setLoop: 0 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance atpWall1 of PV
	(properties
		y 109
		x 113
		view 206
		loop 1
	)
)

(instance atpWall2 of PV
	(properties
		y 109
		x 169
		view 206
		loop 2
	)
)

(instance atpWall3 of PV
	(properties
		y 109
		x 225
		view 206
		loop 3
	)
)

(instance aGirl of Act
	(properties
		y 109
		x 263
		view 207
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setCycle: Walk ignoreActors:)
	)
)

(instance aGull of Act
	(properties
		y 70
		x -66
		view 208
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			setPri: 14
			setCycle: Fwd
			ignoreActors:
			setMotion: MoveTo 319 44
		)
	)
)
