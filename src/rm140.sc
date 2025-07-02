;;; Sierra Script 1.0 - (do not remove this comment)
(script# 140)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm140 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	[local12 96]
	[local108 300]
)
(procedure (localproc_000c param1 param2 &tmp [temp0 200])
	(= local1 (+ 42 (* param1 30)))
	(Format @local108 140 7 (+ param1 96))
	(Display
		@local108
		dsCOORD
		150
		local1
		dsCOLOR
		param2
		dsFONT
		4
		dsWIDTH
		10
	)
	(GetFarText local7 (+ (* local4 5) param1) @temp0)
	(Display
		@temp0
		dsCOORD
		165
		local1
		dsCOLOR
		param2
		dsFONT
		4
		dsWIDTH
		135
	)
)

(procedure (localproc_007c param1 param2 param3 param4 param5 &tmp temp0 temp1)
	(= temp0 (param1 x?))
	(= temp1 (param1 y?))
	(return
		(if
			(and
				(> temp0 param2)
				(> temp1 param3)
				(< temp0 param4)
				(< temp1 param5)
			)
			1
		else
			0
		)
	)
)

(procedure (localproc_00b3 param1)
	(= [local9 (/ param1 16)]
		(| [local9 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (localproc_00cd param1)
	(return
		(if
		(& [local9 (/ param1 16)] (>> $8000 (mod param1 16)))
			1
		else
			0
		)
	)
)

(procedure (localproc_00e7 &tmp temp0 temp1 [temp2 30])
	(if (!= (= temp0 (FOpen {LARRY3.DRV} 1)) -1)
		(= temp1 (FGets @temp2 8 temp0))
		(= local9 (ReadNumber temp1))
		(= local10 (ReadNumber temp1))
		(= local11 (ReadNumber temp1))
	)
	(FClose temp0)
)

(procedure (localproc_0127 &tmp [temp0 40] temp40)
	(if (!= (= temp40 (FOpen {LARRY3.DRV} 2)) -1)
		(Format @temp0 140 13 local9 local10 local11 140 14)
		(FPuts temp40 @temp0)
	)
	(FClose temp40)
)

(procedure (localproc_0163)
	(Graph grFILL_BOX 32 150 189 302 1 15)
	(Graph grUPDATE_BOX 32 150 189 302 1)
)

(instance rm140 of Rm
	(properties
		picture 99
	)
	
	(method (init)
		(Load rsPIC gNumber)
		(Load rsSOUND 140)
		(Load rsSOUND 141)
		(Load rsFONT 4)
		(localproc_00e7)
		(while
			(and
				(< (++ local0) 1000)
				(localproc_00cd (- (= local7 (Random 141 161)) 141))
			)
		)
		(if (>= local0 1000)
			(= local9 0)
			(= local10 0)
			(= local11 0)
			(= local7 (Random 141 161))
		)
		(localproc_00b3 (- local7 141))
		(localproc_0127)
		(Load rsTEXT local7)
		(super init:)
		(= global97 0)
		(proc0_4)
		(User canInput: 0)
		(= gCursorNumber 993)
		(gEgo init: hide:)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 temp2 [temp3 200])
		(switch (= state newState)
			(0
				(proc255_0
					140
					1
					80
					{^Hola!___Me llamo Larry; Larry Laffer!}
					67
					10
					-1
					70
					290
				)
				(if
					(==
						0
						(proc255_0
							140
							2
							80
							{^Rubor!}
							81
							{Echarse para\nAtr*s}
							0
							81
							{^Adelante!\n^Trata de ofenderme!}
							1
						)
					)
					(= global4 1)
					(return)
				)
				(= temp0
					(proc255_0
						140
						3
						80
						{La Realidad}
						81
						{Menos de 12}
						-1
						81
						{De 13 a 17}
						0
						81
						{De 18 a 25}
						18
						81
						{M*s de 25}
						25
					)
				)
				(gTheMusic fade:)
				(switch temp0
					(-1
						(proc255_0 140 4)
						(= global4 1)
					)
					(0
						(proc255_0 140 5)
						(self changeState: 5)
					)
					(else 
						(global2 drawPic: gNumber 7)
						(aSuit init:)
						(gAddToPics add: atpFace doit:)
						(Format @local108 140 6 temp0)
						(proc255_0 @local108 67 -1 144)
						(self cue:)
					)
				)
			)
			(1
				(= local1 42)
				(GetFarText local7 (* local4 5) @local108)
				(= local6 (- (StrAt @local108 0) 48))
				(= temp1 0)
				(while (<= temp1 (StrLen @local108))
					(StrAt @temp3 temp1 (StrAt @local108 (+ temp1 1)))
					(++ temp1)
				)
				(Display
					@temp3
					dsCOORD
					150
					local1
					dsCOLOR
					1
					dsFONT
					4
					dsWIDTH
					150
				)
				(= local1 72)
				(= temp1 1)
				(while (< temp1 5)
					(Format @local108 140 7 (+ temp1 96))
					(Display
						@local108
						dsCOORD
						150
						local1
						dsCOLOR
						1
						dsFONT
						4
						dsWIDTH
						10
					)
					(GetFarText local7 (+ (* local4 5) temp1) @temp3)
					(Display
						@temp3
						dsCOORD
						165
						local1
						dsCOLOR
						1
						dsFONT
						4
						dsWIDTH
						135
					)
					(++ temp1)
					(= local1 (+ local1 30))
				)
			)
			(2
				(if (== local5 local6)
					(localproc_000c local5 2)
					(gTheMusic number: 140 loop: 1 play:)
					(proc255_0 140 8 67 190 8 25 3 88)
					(++ local2)
					(++ local3)
				else
					(localproc_000c local5 4)
					(gTheMusic number: 141 loop: 1 play:)
					(proc255_0 140 9 67 190 8 25 3 88)
					(if local3 (-- local3))
				)
				(aSuit setCel: local3 forceUpd:)
				(= seconds 3)
			)
			(3
				(proc0_5)
				(localproc_0163)
				(= local5 0)
				(if (< (++ local4) 5) (= state 0))
				(= cycles 11)
			)
			(4
				(Format
					@local108
					140
					10
					local2
					(switch local2
						(5 {Totalmente obsceno})
						(4 {Realmente guarro})
						(3 {Bastante sucio})
						(2 {Algo arriesgado})
						(else  {Madre Ganso})
					)
				)
				(localproc_0163)
				(Display
					@local108
					dsCOORD
					160
					60
					dsCOLOR
					1
					dsFONT
					global22
					dsWIDTH
					130
				)
				(= seconds 9)
			)
			(5
				(if (== local2 0) (++ local2))
				(= global88 (- local2 1))
				(if (!= (= temp2 (FOpen {RESOURCE.LL3} 2)) -1)
					(Format @temp3 140 11 global88)
					(FPuts temp2 @temp3)
				)
				(FClose temp2)
				(global2 newRoom: 290)
			)
			(10
				(Format
					@local108
					140
					10
					local2
					(switch local2
						(5 {Totalmente obsceno})
						(4 {Realmente guarro})
						(3 {Bastante sucio})
						(2 {Algo arriesgado})
						(else  {Madre Ganso})
					)
				)
				(localproc_0163)
				(Display
					@local108
					dsCOORD
					160
					60
					dsCOLOR
					1
					dsFONT
					global22
					dsWIDTH
					130
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0 [temp1 33])
		(if (and (not (pEvent claimed?)) (== state 4))
			(self cue:)
		)
		(if
			(or
				(pEvent claimed?)
				(!= state 1)
				(super handleEvent: pEvent)
			)
			(return)
		)
		(switch (pEvent type?)
			(evMOUSEBUTTON
				(cond 
					((localproc_007c pEvent 141 71 300 91) (= local5 1) (self cue:))
					((localproc_007c pEvent 141 101 300 121) (= local5 2) (self cue:))
					((localproc_007c pEvent 141 132 300 152) (= local5 3) (self cue:))
					((localproc_007c pEvent 141 161 300 186) (= local5 4) (self cue:))
				)
			)
			(evKEYBOARD
				(= temp0 (pEvent modifiers?))
				(switch (pEvent message?)
					(KEY_F2
						(pEvent claimed?)
						(proc997_1)
					)
					(KEY_A
						(= local5 1)
						(self cue:)
					)
					(KEY_B
						(= local5 2)
						(self cue:)
					)
					(KEY_C
						(= local5 3)
						(self cue:)
					)
					(KEY_D
						(= local5 4)
						(self cue:)
					)
					(KEY_A
						(= local5 1)
						(self cue:)
					)
					(KEY_B
						(= local5 2)
						(self cue:)
					)
					(KEY_C
						(= local5 3)
						(self cue:)
					)
					(KEY_D
						(= local5 4)
						(self cue:)
					)
					(KEY_ALT_x
						(if (& temp0 $0004)
							(pEvent claimed: 1)
							(proc255_0 140 0)
							(= local2 6)
							(while (u> local2 5)
								(= local2 (proc255_3 {^Solo del 1 al 5!}))
							)
							(self changeState: 4)
						)
					)
				)
			)
		)
	)
)

(instance atpFace of PV
	(properties
		y 52
		x 50
		view 140
		priority 15
	)
)

(instance aSuit of Prop
	(properties
		y 77
		x 83
		view 140
		loop 1
	)
)
