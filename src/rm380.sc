;;; Sierra Script 1.0 - (do not remove this comment)
(script# 380)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm380 0
)
(synonyms
	(use class do)
)

(local
	local0
	local1
	local2
	local3
	gEgoX
	gEgoY
	gEgoPriority
	local7
	local8
	local9
	local10
	local11
	local12
)
(procedure (localproc_001a param1)
	(proc0_6)
	(proc0_3)
	(= local11 param1)
	(= gEgoX (gEgo x?))
	(= gEgoY (gEgo y?))
	(= gEgoPriority (gEgo priority?))
	(switch (++ local0)
		(1
			(proc255_0
				{Alterna entre clic izquierdo y derecho para hacer los ejercicios.}
			)
		)
		(2 (proc255_0 380 31))
		(3 (proc255_0 380 32))
		(4 (proc255_0 380 33))
		(5
			(proc255_0 380 34)
			(= local0 0)
		)
	)
	(gEgo viewer: 0 illegalBits: 0 ignoreActors:)
	(User mapKeyToDir: 0 canInput: 1)
)

(procedure (localproc_00c8)
	(= local11 0)
	(= local12 0)
	(proc0_1 2 (+ 704 global118))
	(gEgo
		posn: gEgoX gEgoY
		setPri: gEgoPriority
		viewer: egoViewer
	)
	(aBigEgo
		cycleSpeed: 0
		posn: 1234 1234
		setMotion: 0
		stopUpd:
	)
	(if
		(and
			(>= global117 local10)
			(>= global116 local9)
			(>= global114 local7)
			(>= global115 local8)
		)
		(proc0_3)
		(RoomScript changeState: 39)
	)
)

(procedure (localproc_013c &tmp [temp0 11])
	(= local2 0)
	(Display
		(Format
			@temp0
			380
			35
			global117
			global116
			global114
			global115
		)
		dsCOORD
		122
		82
		dsFONT
		999
		dsCOLOR
		12
		dsBACKGROUND
		0
	)
)

(instance rm380 of Rm
	(properties
		picture 380
		horizon 1
		east 370
	)
	
	(method (init &tmp temp0)
		(if (not global118)
			(Load rsSOUND 380)
			(Load rsVIEW 383)
			(Load rsVIEW 384)
			(Load rsVIEW 385)
			(Load rsVIEW 386)
			(Load rsVIEW 387)
		)
		(super init:)
		(gAddToPics add: atpPullupHandles doit:)
		(aBigEgo init:)
		(aActor1 init:)
		(aCenterWeight init:)
		(aRoundBar init:)
		(aExtraBar init:)
		(aDumbbell init:)
		(aBarPullBarView init:)
		(aLegCurlBar init:)
		(self setScript: RoomScript)
		(= temp0 10)
		(= local10 temp0)
		(= local9 temp0)
		(= local7 temp0)
		(= local8 temp0)
		(proc0_1 1 (+ 704 global118))
		(gEgo posn: 270 175 setPri: 9 viewer: egoViewer init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0040) (global2 newRoom: 370))
	)
	
	(method (changeState newState)
		(proc21_1 self newState 1 4)
		(switch (= state newState)
			(0)
			(1
				(localproc_001a 4)
				(gEgo
					view: 381
					posn: 201 135
					setLoop: 8
					cel: 0
					cycleSpeed: 1
				)
				(aActor1
					setStep: 3 5
					posn: 155 45
					view: 384
					setLoop: 2
					setPri: 12
				)
				(aBigEgo
					view: 384
					setLoop: 1
					setPri: 13
					posn: 155 80
					stopUpd:
				)
				(aLegCurlBar hide:)
				(self cue:)
			)
			(2 (= local2 1) (= local12 3))
			(3
				(= local12 1)
				(gEgo cel: 0 setCycle: End)
				(aActor1 setMotion: MoveTo 155 15 self)
				(aCenterWeight setMotion: MoveTo 153 136)
			)
			(4
				(= local12 4)
				(if local2
					(if (== (++ global115) local8)
						(proc255_4 380 17 global115)
						(RoomScript changeState: 7)
					)
					(localproc_013c)
				)
			)
			(5
				(= local12 2)
				(gEgo setCycle: Beg)
				(aActor1 setMotion: MoveTo 155 50 self)
				(aCenterWeight setMotion: MoveTo 153 166)
				(= state 1)
			)
			(6)
			(7
				(User mapKeyToDir: 1 canInput: 0 canControl: 0)
				(aCenterWeight setMotion: MoveTo 153 166 self)
				(aActor1 setMotion: MoveTo 155 50 self)
			)
			(8)
			(9
				(aLegCurlBar show:)
				(aCenterWeight stopUpd:)
				(localproc_00c8)
			)
			(10
				(localproc_001a 3)
				(gEgo
					cycleSpeed: 1
					view: 381
					posn: 216 163
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(11
				(aRoundBar hide:)
				(aBigEgo view: 382 cel: 0 setPri: 13 posn: 156 24)
				(aDumbbell hide:)
				(aActor1
					view: 380
					setLoop: 0
					setStep: 7 7
					setPri: 14
					posn: 155 34
				)
				(gEgo setPri: 13 setLoop: 2 posn: 219 159)
				(self cue:)
			)
			(12 (= local2 1) (= local12 3))
			(13
				(= local12 1)
				(gEgo cel: 0 setCycle: End self)
				(aActor1 setMotion: MoveTo 155 20)
				(aBigEgo setCycle: End)
			)
			(14
				(= local12 4)
				(if local2
					(if (== (++ global114) local7)
						(proc255_4 380 18 (* 100 global114))
						(RoomScript changeState: 17)
					)
					(localproc_013c)
				)
			)
			(15
				(= local12 2)
				(gEgo setCycle: Beg self)
				(aActor1 setMotion: MoveTo 155 34)
				(aBigEgo setCycle: Beg)
				(= state 11)
			)
			(16)
			(17
				(User mapKeyToDir: 1 canInput: 0 canControl: 0)
				(aBigEgo posn: 1234 1234 setMotion: 0)
				(aActor1 posn: 155 34 setMotion: 0 stopUpd:)
				(aRoundBar show:)
				(aDumbbell show:)
				(gEgo
					posn: 216 163
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
				(gGame setCursor: 998 (HaveMouse))
			)
			(18 (localproc_00c8))
			(19
				(gGame setCursor: 998 (HaveMouse))
				(gEgo
					illegalBits: 0
					viewer: 0
					setPri: 13
					setMotion: MoveTo 156 171 self
				)
			)
			(20
				(gEgo
					view: 381
					posn: 156 146
					setLoop: 5
					cel: 0
					setCycle: End self
				)
			)
			(21
				(localproc_001a 2)
				(gEgo
					posn: 165 143
					setPri: 13
					setLoop: 6
					cel: 0
					cycleSpeed: 2
				)
				(aBigEgo view: 384 setLoop: 0 posn: 302 1)
				(self cue:)
			)
			(22 (= local2 1) (= local12 3))
			(23
				(= local12 1)
				(gEgo setCycle: End)
				(aBigEgo setMotion: MoveTo 302 -52 self)
			)
			(24
				(= local12 4)
				(if local2
					(if (== (++ global116) local9)
						(proc255_4 380 19 global116)
						(RoomScript changeState: 27)
					)
					(localproc_013c)
				)
			)
			(25
				(= local12 2)
				(gEgo setCycle: Beg)
				(aBigEgo setMotion: MoveTo 302 1 self)
				(= state 21)
			)
			(26)
			(27
				(gGame setCursor: 998 (HaveMouse))
				(User mapKeyToDir: 1)
				(= gEgoX 156)
				(= gEgoY 175)
				(localproc_00c8)
			)
			(28
				(localproc_001a 1)
				(gEgo
					cycleSpeed: 1
					view: 381
					posn: 131 165
					setLoop: 1
					cel: 0
					setCycle: End self
					setPri: 13
				)
			)
			(29
				(gEgo setLoop: 4 setCel: 0 posn: 126 165)
				(aBigEgo
					cycleSpeed: 1
					view: 383
					posn: 76 115
					setPri: 13
					cel: 0
				)
				(aActor1
					setStep: 3 5
					posn: 155 45
					view: 384
					setLoop: 2
					setPri: 12
				)
				(aExtraBar hide:)
				(aBarPullBarView hide:)
				(self cue:)
			)
			(30 (= local2 1) (= local12 4))
			(31
				(= local12 2)
				(gEgo setCycle: End)
				(aBigEgo setCycle: End)
				(aActor1 setMotion: MoveTo 155 15 self)
				(aCenterWeight setMotion: MoveTo 153 136)
			)
			(32
				(= local12 3)
				(if local2
					(if (== (++ global117) local10)
						(proc255_4 380 20 global117)
						(RoomScript changeState: 35)
					)
					(localproc_013c)
				)
			)
			(33
				(= local12 1)
				(gEgo setCycle: Beg)
				(aBigEgo setCycle: Beg)
				(aActor1 setMotion: MoveTo 155 50 self)
				(aCenterWeight setMotion: MoveTo 153 166)
				(= state 29)
			)
			(34)
			(35
				(User mapKeyToDir: 1 canInput: 0 canControl: 0)
				(aCenterWeight setMotion: MoveTo 153 166 self)
				(aActor1 setMotion: MoveTo 155 50 self)
				(aBarPullBarView show: stopUpd:)
				(aExtraBar show: stopUpd:)
				(aBigEgo posn: 999 999)
				(gEgo posn: 131 165 setLoop: 3 cel: 0 setCycle: End self)
			)
			(36)
			(37)
			(38
				(aCenterWeight stopUpd:)
				(localproc_00c8)
			)
			(39
				(= global118 20)
				(= local3 1)
				(= global66 720)
				(proc0_1 2 724)
				(proc0_3)
				(= seconds 3)
			)
			(40
				(proc255_0 380 21)
				(gTheMusic number: 380 loop: global72 play:)
				(= local1 0)
				(proc0_1 2 704)
				(proc0_3)
				(= global101 (gGame setSpeed: 6))
				(= seconds 3)
			)
			(41
				(gEgo
					illegalBits: 64
					ignoreActors:
					view: 385
					setLoop: local1
					cel: 0
					setCycle: End self
				)
			)
			(42
				(cond 
					((== 0 local1) (proc255_0 380 22))
					((== 3 local1) (proc255_0 380 23))
				)
				(if (>= 4 (++ local1)) (= state (- state 2)))
				(= cycles 11)
			)
			(43
				(proc255_0 380 24)
				(gEgo view: 386 loop: 0 cel: 0 setCycle: End)
				(= cycles 18)
			)
			(44
				(gEgo loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 33)
			)
			(45
				(proc255_0 380 25)
				(= cycles 33)
			)
			(46
				(gEgo loop: 2 cel: 0 setCycle: End)
				(= cycles 11)
			)
			(47
				(proc255_0 380 26)
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(48
				(gEgo loop: 3 cel: 0 setCycle: End)
				(= cycles 15)
			)
			(49
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(50
				(proc255_0 380 27)
				(gEgo loop: 5 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(51
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(52
				(gEgo loop: 4 cel: 0 setCycle: End)
				(= cycles 15)
			)
			(53
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(54
				(gEgo loop: 6 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(55
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(56
				(gEgo view: 387 loop: 0 cel: 0 setCycle: End self)
			)
			(57
				(proc255_0 380 28)
				(gEgo loop: 1 setCycle: Fwd)
				(= cycles 33)
			)
			(58
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(59
				(proc0_1 0 724)
				(gEgo viewer: egoViewer)
				(gGame changeScore: 100)
				(proc255_0 380 29)
				(gTheMusic number: 399 loop: global72 play:)
				(gGame setSpeed: global101)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(and local11 (== (pEvent type?) evMOUSEBUTTON))
			(pEvent claimed: 1)
			(cond 
				((& (pEvent modifiers?) emSHIFT)
					(cond 
						((== local12 3) (self cue:))
						((== local12 2) (++ state) (self cue:))
					)
				)
				((== local12 4) (self cue:))
				((== local12 1) (++ state) (self cue:))
			)
		)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'nightstand,(nightstand<up),(get<off,up)')
					(Said '(get<off,up),exit,cease,done')
					(Said 'exit/barstool')
				)
				(switch local11
					(0 (proc0_8))
					(4 (RoomScript changeState: 7))
					(3 (RoomScript changeState: 17))
					(2 (RoomScript changeState: 27))
					(1 (RoomScript changeState: 35))
				)
			)
			((Said 'lie,(work<out),use')
				(cond 
					(local11 (proc255_0 380 0))
					((& (gEgo onControl:) $0008)
						(if (>= global115 local8)
							(proc255_0 380 1)
						else
							(self changeState: 1)
						)
					)
					((& (gEgo onControl:) $0004)
						(if (>= global114 local7)
							(proc255_0 380 2)
						else
							(self changeState: 10)
						)
					)
					((& (gEgo onControl:) $0010)
						(if (>= global116 local9)
							(proc255_0 380 3)
						else
							(self changeState: 19)
						)
					)
					((& (gEgo onControl:) $0020)
						(if (>= global117 local10)
							(proc255_0 380 4)
						else
							(self changeState: 28)
						)
					)
					(else (proc255_0 380 5) (proc255_0 380 6))
				)
			)
			(
				(or
					(Said 'use/equipment<drag,bar')
					(Said 'use/bar,drag')
					(Said 'use/drag<bar')
					(Said 'drag/bar')
				)
				(cond 
					(local11 (proc255_0 380 0))
					((>= global117 local10) (proc255_0 380 7))
					((& (gEgo onControl:) $0020) (self changeState: 28))
					(else (proc255_0 380 8))
				)
			)
			(
				(or
					(Said 'use/equipment<curl')
					(Said 'curl')
					(Said 'use/curl')
				)
				(cond 
					(local11 (proc255_0 380 0))
					((>= global115 local8) (proc255_0 380 9))
					((& (gEgo onControl:) $0008) (self changeState: 1))
					(else (proc255_0 380 10))
				)
			)
			(
				(or
					(Said 'use/equipment<drag,barstool')
					(Said 'drag,bell')
					(Said 'barstool<drag/')
					(Said 'get<on/barstool')
					(Said 'increase,use/drag,bell,bell')
				)
				(cond 
					(local11 (proc255_0 380 0))
					((>= global114 local7) (proc255_0 380 11))
					((& (gEgo onControl:) $0004) (self changeState: 10))
					(else (proc255_0 380 12))
				)
			)
			(
				(or
					(Said 'use/equipment<up,pullup,drag')
					(Said 'use/up<drag')
					(Said 'pullup')
					(Said '(up<drag)')
					(Said 'use/pullup')
				)
				(cond 
					(local11 (proc255_0 380 0))
					((>= global116 local9) (proc255_0 380 13))
					((& (gEgo onControl:) $0010) (self changeState: 19))
					(else (proc255_0 380 14))
				)
			)
			((Said 'perspiration') (if local11 (proc0_8) else (proc255_0 380 15)))
			(
			(and (Said 'look>') (Said '[/equipment,pos,area]')) (proc255_0 380 16))
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 106)
						(< (pEvent x?) 128)
						(> (pEvent y?) 146)
						(< (pEvent y?) 172)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								(local11 (proc255_0 380 0))
								((>= global117 local10) (proc255_0 380 7))
								((& (gEgo onControl:) $0020) (self changeState: 28))
								(else (proc255_0 380 8))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 142)
						(< (pEvent x?) 166)
						(> (pEvent y?) 150)
						(< (pEvent y?) 172)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								(local11 (proc255_0 380 0))
								((>= global116 local9) (proc255_0 380 13))
								((& (gEgo onControl:) $0010) (self changeState: 19))
								(else (proc255_0 380 14))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 167)
						(< (pEvent x?) 202)
						(> (pEvent y?) 131)
						(< (pEvent y?) 168)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								(local11 (proc255_0 380 0))
								((>= global114 local7) (proc255_0 380 11))
								((& (gEgo onControl:) $0004) (self changeState: 10))
								(else (proc255_0 380 12))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 203)
						(< (pEvent x?) 230)
						(> (pEvent y?) 150)
						(< (pEvent y?) 170)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								(local11 (proc255_0 380 0))
								((>= global115 local8) (proc255_0 380 9))
								((& (gEgo onControl:) $0008) (self changeState: 1))
								(else (proc255_0 380 10))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance atpPullupHandles of PV
	(properties
		y 143
		x 165
		view 380
		loop 2
		priority 9
		signal $4000
	)
)

(instance aRoundBar of View
	(properties
		y 142
		x 201
		view 381
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 stopUpd:)
	)
)

(instance aBarPullBarView of View
	(properties
		y 63
		x 30
		view 380
		loop 1
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 stopUpd:)
	)
)

(instance aLegCurlBar of View
	(properties
		y 164
		x 226
		view 381
		cel 2
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance aDumbbell of View
	(properties
		y 34
		x 155
		view 380
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 stopUpd:)
	)
)

(instance aExtraBar of View
	(properties
		y 138
		x 128
		view 381
		cel 1
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance aActor1 of Act
	(properties
		y 999
		x 155
		view 380
		signal $4000
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreHorizon: stopUpd:)
	)
)

(instance aCenterWeight of Act
	(properties
		y 166
		x 153
		view 381
		signal $4000
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setStep: 1 5 setLoop: 7 setPri: 11 stopUpd:)
	)
)

(instance aBigEgo of Act
	(properties
		y 999
		x 156
		view 382
		signal $4000
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setPri: 14 setStep: 6 6 ignoreHorizon: stopUpd:)
	)
)

(instance egoViewer of Code
	(properties)
	
	(method (doit)
		(cond 
			((< (gEgo y?) 172) (gEgo setPri: 4))
			((& (gEgo onControl:) $0002) (gEgo setPri: 9))
			(else (gEgo setPri: -1))
		)
	)
)
