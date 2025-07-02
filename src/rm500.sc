;;; Sierra Script 1.0 - (do not remove this comment)
(script# 500)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Obj)

(public
	rm500 0
	proc500_1 1
	proc500_2 2
)

(local
	[local0 66]
	[local66 22]
	[local88 20] = [-16564 5177 19666 27846 18175 19476 14668 -11668 -14778 -2049 -12039 -6221 -28275 -28200 -29441 -24077 -12441 8987 9137 6655]
	local108 =  500
	local109
	gEgoEdgeHit
)
(procedure (proc500_1 &tmp temp0)
	(global2 drawPic: local108)
	(if (proc500_2 (+ 0 local109))
		(global2 overlay: (+ local108 4))
	)
	(if (proc500_2 (+ 80 local109))
		(global2 overlay: (+ local108 2))
	)
	(if (proc500_2 (+ 240 local109))
		(global2 overlay: (+ local108 3))
	)
	(if (proc500_2 (+ 160 local109))
		(global2 overlay: (+ local108 1))
	)
)

(procedure (proc500_2 param1)
	(return
		(if
		(& [local88 (/ param1 16)] (>> $8000 (mod param1 16)))
			1
		else
			0
		)
	)
)

(instance rm500 of Rm
	(properties
		picture 500
		horizon 22
	)
	
	(method (init &tmp temp0)
		(= temp0 500)
		(while (< temp0 510)
			(Load rsPIC temp0)
			(++ temp0)
		)
		(Load rsVIEW 800)
		(Load rsVIEW 501)
		(Load rsVIEW 502)
		(Load rsVIEW 503)
		(if (gEgo has: 13) (Load rsVIEW ((Inv at: 13) view?)))
		(Load rsSOUND 501)
		(Load rsSOUND 502)
		(Load rsSOUND 503)
		(super init:)
		(gTheMusic number: 500 loop: global72 play:)
		(if (not global108) (= global108 1) (= global66 800))
		(self setScript: RoomScript)
		(if (== gGNumber 510)
			(gEgo posn: 177 26)
			(= local109 1)
		else
			(gEgo posn: (Random 130 234) 188)
			(= local109 68)
		)
		(proc500_1)
		(proc0_1)
		(gEgo baseSetter: SteadyBase setCycle: SlowWalk init:)
		(User canInput: 0 canControl: 1 mapKeyToDir: 1)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (gEgo edgeHit?)
			(= gEgoEdgeHit (gEgo edgeHit?))
			(gEgo edgeHit: 0 illegalBits: 0)
			(gGame setCursor: global21 1)
			(proc0_3)
			(++ global200)
			(self changeState: 0)
			(cond 
				((< global200 8) (gEgo view: 800 moveSpeed: 0))
				((< global200 14)
					(gEgo view: 501 moveSpeed: 0)
					(if (!= 501 (gTheMusic number?)) (gTheMusic fade:))
				)
				((< global200 17)
					(gEgo view: 502 moveSpeed: 1)
					(if (!= 502 (gTheMusic number?)) (gTheMusic fade:))
				)
				((< global200 18)
					(gEgo view: 503 moveSpeed: 2)
					(if (!= 503 (gTheMusic number?)) (gTheMusic fade:))
				)
				(else (gEgo view: 503 moveSpeed: 3) (self changeState: 2))
			)
			(switch gEgoEdgeHit
				(1
					(if (== local109 1)
						(gTheMusic fade:)
						(if (not (proc0_22 37))
							(gGame changeScore: 100)
							(proc255_0 500 0)
							(proc255_0 500 1)
						)
						(global2 newRoom: 510)
						(return)
					else
						(= local109 (- local109 8))
					)
				)
				(3
					(if (== local109 68)
						(global2 newRoom: 245)
						(return)
					else
						(= local109 (+ local109 8))
					)
				)
				(2 (++ local109))
				(4 (-- local109))
			)
			(if (== local108 505)
				(= local108 500)
				(switch gEgoEdgeHit
					(1
						(gEgo posn: (Random 130 234) 187)
					)
					(3 (gEgo posn: 177 26))
					(2 (gEgo posn: 1 74))
					(else  (gEgo posn: 317 74))
				)
			else
				(= local108 505)
				(switch gEgoEdgeHit
					(1
						(gEgo posn: (Random 80 163) 187)
					)
					(3 (gEgo posn: 188 26))
					(2 (gEgo posn: 1 83))
					(else  (gEgo posn: 314 128))
				)
			)
			(proc500_1)
			(Animate (gCast elements?) 0)
			(gEgo illegalBits: -32768)
			(proc0_4)
			(gGame setCursor: global20 (HaveMouse))
			(return)
		)
		(if (== (GameIsRestarting) 2)
			(proc500_1)
			(Animate (gCast elements?) 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(cond 
					(
						(and
							(>= global200 8)
							(<= global200 13)
							(!= 501 (gTheMusic number?))
						)
						(gTheMusic number: 501 loop: global72 play:)
					)
					(
						(and
							(>= global200 14)
							(<= global200 16)
							(!= 502 (gTheMusic number?))
						)
						(gTheMusic number: 502 loop: global72 play:)
					)
					(
						(and
							(<= global200 18)
							(>= global200 17)
							(!= 503 (gTheMusic number?))
						)
						(gTheMusic number: 503 loop: global72 play:)
					)
				)
				(cond 
					((== global200 4) (proc255_0 500 13))
					((== global200 8) (proc255_0 500 14))
					((== global200 12) (proc255_0 500 15))
					((== global200 16)
						(proc255_0 500 16)
						(proc255_0 500 17)
						(proc255_0 500 18)
						(proc255_0 500 19)
					)
				)
			)
			(2 (= seconds 3))
			(3
				(proc255_0 500 20)
				(= seconds 3)
			)
			(4
				(proc255_0 500 21)
				(= seconds 3)
			)
			(5
				(proc0_3)
				(proc255_0 500 22)
				(gEgo
					illegalBits: 0
					setMotion: 0
					view: 504
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(6
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 505
					register: (Format @local0 500 23)
					next: (Format @local66 500 24)
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return (pEvent claimed?)))
		(return
			(cond 
				((Said 'get/bamboo') (proc255_0 500 2))
				((Said 'climb/bamboo') (proc255_0 500 3))
				((Said 'attack/bamboo') (proc255_0 500 4))
				((Said 'nightstand,(get,nightstand<up)') (proc255_0 500 5))
				(
					(or
						(Said 'sip/water')
						(Said 'get/drink<1')
						(Said 'use,drink,drain/water,beer,bottle')
					)
					(cond 
						((!= gGNumber_2 0) (proc0_9))
						((not (gEgo has: 13)) (proc0_12))
						((== ((Inv at: 13) view?) 28) (proc255_0 500 6 82 28 0 0))
						(else
							(proc0_6)
							(gGame changeScore: 20)
							(= global200 0)
							(gTheMusic number: 500 loop: global72 play:)
							(proc255_0 500 7 82 29 0 0)
							(proc255_0 500 8)
							(proc0_24 13)
							(proc0_1)
							(gEgo baseSetter: SteadyBase setCycle: SlowWalk)
							(self changeState: 0)
						)
					)
				)
				((Said 'look>')
					(cond 
						((Said '[/area]') (proc255_0 500 9) (proc255_0 500 10 67 -1 144))
						((Said '/bamboo')
							(proc255_0 500 11)
							(proc255_0 (Format @local0 500 12 global92) 67 -1 144)
							(++ global92)
						)
					)
				)
			)
		)
	)
)

(instance SteadyBase of Code
	(properties)
	
	(method (doit)
		(gEgo brBottom: (+ (gEgo y?) 1))
		(gEgo brTop: (- (gEgo brBottom?) 2))
		(gEgo brLeft: (- (gEgo x?) 10))
		(gEgo brRight: (+ (gEgo x?) 10))
	)
)

(instance SlowWalk of Fwd
	(properties)
	
	(method (doit)
		(if
			(or
				(!= (client x?) (client xLast?))
				(!= (client y?) (client yLast?))
			)
			(super doit:)
		)
	)
)
